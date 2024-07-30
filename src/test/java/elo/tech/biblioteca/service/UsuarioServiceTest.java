package elo.tech.biblioteca.service;

import elo.tech.biblioteca.domain.Usuario;
import elo.tech.biblioteca.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class UsuarioServiceTest {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;
//    public UsuarioServiceTest(UsuarioRepository usuarioRepository, UsuarioService usuarioService) {
//        this.usuarioRepository = usuarioRepository;
//        this.usuarioService = usuarioService;
//    }


    @Test
    void create() {

        Usuario create = Usuario.builder()
                .nome("João Pedro").email("joaojogao@gmail.com")
                .build();
        Usuario novo = this.usuarioRepository.save(create);

        assertNotNull(novo);
        assertEquals(create.getNome(), novo.getNome());

    }

    @Test
    @DisplayName("Verifica se um usuário está sendo criado.")
    void createService(){
        Usuario create = Usuario.builder()
                .nome("João Pedro").email("joaojogao@gmail.com")
                .build();

        Usuario novo = this.usuarioService.create(create);

        assertNotNull(novo);
    }

    @Test
    @DisplayName("Verifica se os atributos criados coincidem com os encontrados no banco.")
    void findById() {

        Usuario create = Usuario.builder()
                .nome("João Pedro").email("joaojogao@gmail.com").telefone("joaojogao@gmail.com")
                .build();

        Usuario novo = this.usuarioService.create(create);

        Optional<Usuario> finded =this.usuarioRepository.findById(novo.getId());

        assertNotNull(finded);
        assertEquals(finded.get().getNome(), novo.getNome());
        assertEquals(finded.get().getTelefone(), novo.getTelefone());
        assertEquals(finded.get().getId(), novo.getId());
    }

    @Test
    @DisplayName("Verifica se os usuários estão sendo excluidos da base.")
    void delete(){

        Usuario create = Usuario.builder()
                .nome("João Pedro").email("joaojogao@gmail.com").telefone("joaojogao@gmail.com")
                .build();

        Usuario novo = this.usuarioService.create(create);
        this.usuarioService.delete(novo.getId());

        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
            usuarioService.findById(novo.getId());
        });

    }
}