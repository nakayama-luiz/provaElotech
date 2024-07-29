package elo.tech.biblioteca.service;

import elo.tech.biblioteca.domain.*;
import elo.tech.biblioteca.domain.enums.Categoria;
import elo.tech.biblioteca.repository.AutorRepository;
import elo.tech.biblioteca.repository.LivroRepository;
import elo.tech.biblioteca.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import elo.tech.biblioteca.domain.dto.createLivroDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private final LivroRepository livroRepository;
    @Autowired
    private AutorService autorService;
    @Autowired
    private final AutorRepository autorRepository;
    @Autowired
    private final UsuarioRepository usuarioRepository;

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository, UsuarioRepository usuarioRepository) {
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
        this.autorRepository = autorRepository;
    }

    public Livros create(createLivroDTO createLivroDTO) {

       if(createLivroDTO.getAutor().isEmpty()){
           throw new EntityNotFoundException("Informe um autor para cadastrar livros.");
       }

        List<Autor> autores = new ArrayList<>();

        for (Autor autor : createLivroDTO.getAutor()) {
            Autor persistedAutor = autorRepository.findById(autor.getId())
                    .orElseThrow(() -> new RuntimeException("Autor não cadastrado na base."));
            autores.add(persistedAutor);

        }

        Livros livro = Livros.builder()
                .titulo(createLivroDTO.getTitulo())
                .ISBN(createLivroDTO.getISBN())
                .data_publicacao(createLivroDTO.getData_publicacao())
                .categorias(createLivroDTO.getCategorias())
                .build();


        Livros savedLivro = this.livroRepository.save(livro);

        for (Autor autor : autores) {
            autor.getLivros().add(savedLivro);
            autorRepository.save(autor);
        }

        savedLivro.setAutor(autores);
        return savedLivro;
    }

    public List<Livros> recomendar(Long usuario_id){

        if(!(this.usuarioRepository.existsUsuarioById(usuario_id))){
            throw new EntityNotFoundException("Usuário não foi encontrado!");
        }

        return this.livroRepository.recomendarLivrosPorUsuario(usuario_id);
    }

    public Livros findById(Long id){
        return this.livroRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("O livro não foi encontrado."));
    }

    public Livros update(Livros livros){
        return this.livroRepository.save(livros);
    }

    public void delete(Long id){
        this.livroRepository.deleteById(id);
    }

    public Livros createLivroGoogleApi(GoogleBookDataResponse bookDataResponse){

        VolumeInfo response = bookDataResponse.getItems().get(0).getVolumeInfo();

        Livros livro = Livros.builder()
                .titulo(response.getTitle())
                .build();

        for(IndustryIdentifiers identifiers: response.getIndustryIdentifiers()){
            if(identifiers.getType().equals("ISBN_13")){
                livro.setISBN(identifiers.getIdentifier());
            }
        }

         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         LocalDate data_publicacao = LocalDate.from(dtf.parse(response.getPublishedDate()));

         livro.setData_publicacao(data_publicacao);

       for(String categoria: response.getCategories()){
           livro.setCategorias(List.of(Categoria.valueOf(categoria)));
       }

        List<Autor> autores = response.getAuthors().stream()
                .map(s -> this.autorService.findOrCreateAutor(s))
                .collect(Collectors.toList());

        Livros savedLivro = this.livroRepository.save(livro);

        for (Autor autor : autores) {
            autor.getLivros().add(savedLivro);
            this.autorRepository.save(autor);
        }

        savedLivro.setAutor(autores);

        return savedLivro;
    }
}