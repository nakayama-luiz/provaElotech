package elo.tech.biblioteca.repository;

import elo.tech.biblioteca.domain.Livros;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livros, Long> {


//    @Query(value = "SELECT DISTINCT l.* FROM Livros l " +
//            "JOIN livros_categorias lc ON l.id = lc.livros_id " +
//            "WHERE lc.categorias IN (" +
//            "    SELECT lc2.categorias FROM Livros l2 " +
//            "    JOIN livros_categorias lc2 ON l2.id = lc2.livros_id " +
//            "    JOIN Emprestimos e ON e.livros_id = l2.id " +
//            "    WHERE e.usuario_id = :usuarioId" +
//            ") " +
//            "AND l.id NOT IN (" +
//            "    SELECT e.livros_id FROM Emprestimos e WHERE e.usuario_id = :usuarioId" +
//            ")", nativeQuery = true)
        @Query(value = "SELECT DISTINCT l.* FROM Livros l " +
        "JOIN livros_categorias lc ON l.id = lc.livros_id " +
        "WHERE lc.categoria_id IN (" +
        "    SELECT lc2.categoria_id FROM Livros l2 " +
        "    JOIN livros_categorias lc2 ON l2.id = lc2.livros_id " +
        "    JOIN Emprestimos e ON e.livros_id = l2.id " +
        "    WHERE e.usuario_id = :usuarioId" +
        ") " +
        "AND l.id NOT IN (" +
        "    SELECT e.livros_id FROM Emprestimos e WHERE e.usuario_id = :usuarioId" +
        ")", nativeQuery = true)
    List<Livros> recomendarLivrosPorUsuario(Long usuarioId);

}
