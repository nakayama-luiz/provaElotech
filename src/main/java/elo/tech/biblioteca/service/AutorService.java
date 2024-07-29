package elo.tech.biblioteca.service;

import elo.tech.biblioteca.domain.Autor;
import elo.tech.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;
    public Autor findOrCreateAutor(String nome) {

        Autor findedAutor = autorRepository.findByNome(nome);

        if (findedAutor == null) {

            findedAutor = new Autor();
            findedAutor.setNome(nome);

            findedAutor = autorRepository.save(findedAutor);
        }
        return findedAutor;
    }
}
