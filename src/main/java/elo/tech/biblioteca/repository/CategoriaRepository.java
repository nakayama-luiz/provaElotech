package elo.tech.biblioteca.repository;

import elo.tech.biblioteca.domain.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categorias, Long> {

    Optional<Categorias> findByCategoria(String categoria);
}
