package elo.tech.biblioteca.repository;

import elo.tech.biblioteca.domain.Emprestimos;
import elo.tech.biblioteca.domain.Livros;
import elo.tech.biblioteca.domain.Usuario;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimosRepository extends JpaRepository<Emprestimos, Long> {

    boolean existsEmprestimosByUsuarioAndStatusIsTrue(Usuario usuario);

    Emprestimos findByUsuarioAndStatusIsTrue(Usuario usuario);
}
