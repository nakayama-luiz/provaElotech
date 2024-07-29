package elo.tech.biblioteca.repository;

import elo.tech.biblioteca.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    boolean existsByNome(String nome);
    Autor findByNome(String nome);

}
