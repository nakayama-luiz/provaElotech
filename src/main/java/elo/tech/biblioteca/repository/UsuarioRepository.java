package elo.tech.biblioteca.repository;

import elo.tech.biblioteca.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsUsuarioById(Long usuario_id);


}
