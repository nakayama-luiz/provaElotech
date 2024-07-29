package elo.tech.biblioteca.service;


import elo.tech.biblioteca.domain.Emprestimos;
import elo.tech.biblioteca.domain.Livros;
import elo.tech.biblioteca.domain.Usuario;
import elo.tech.biblioteca.domain.dto.createEmprestimoDTO;
import elo.tech.biblioteca.domain.dto.updateEmprestimoDTO;
import elo.tech.biblioteca.repository.EmprestimosRepository;
import elo.tech.biblioteca.repository.LivroRepository;
import elo.tech.biblioteca.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmprestimoService {


    @Autowired
    private final EmprestimosRepository emprestimosRepository;

    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Autowired
    private final LivroRepository livroRepository;

    public EmprestimoService(EmprestimosRepository emprestimosRepository, UsuarioRepository usuarioRepository, LivroRepository livroRepository) {
        this.emprestimosRepository = emprestimosRepository;
        this.usuarioRepository = usuarioRepository;
        this.livroRepository = livroRepository;
    }

    public boolean existenceValidator(Usuario usuario){
        return this.emprestimosRepository.existsEmprestimosByUsuarioAndStatusIsTrue(usuario);
    }


    public Emprestimos create(createEmprestimoDTO emprestimo){
        Livros livro = this.livroRepository.findById(emprestimo.getLivro().getId()).orElseThrow(
                () -> new EntityNotFoundException("Não foi possível encontrar o livro"));

        Usuario usuario = this.usuarioRepository.findById(emprestimo.getUsuario().getId()).orElseThrow(
                () -> new EntityNotFoundException("Não foi possível encontrar o usuário solicitado."));

        if(existenceValidator(usuario )){
            throw new RuntimeException("O usuário já poussi um empréstimo ativo, verifique.");
        }

        Emprestimos createdEmprestimo = Emprestimos.builder().livro(livro).status(true).usuario(usuario).build();

        return this.emprestimosRepository.save(createdEmprestimo);
    }

    public Emprestimos findOneById(Long id){
        return this.emprestimosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não foi encontrado o emprestímo."));
    }

    public Emprestimos update(updateEmprestimoDTO emprestimo){

        if(existenceValidator(emprestimo.getUsuario())){

            Emprestimos findedEmprestimo = this.emprestimosRepository.findByUsuarioAndStatusIsTrue(emprestimo.getUsuario());

            if (findedEmprestimo.getLivro().equals(emprestimo.getLivro())) {
                findedEmprestimo.setStatus(emprestimo.getStatus());
                return this.emprestimosRepository.save(findedEmprestimo);
            }
        }
        throw new RuntimeException("Usuário ou livro não encontrado ou empréstimo não está ativo");

    }

}
