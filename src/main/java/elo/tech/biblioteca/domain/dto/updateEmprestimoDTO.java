package elo.tech.biblioteca.domain.dto;


import elo.tech.biblioteca.domain.Emprestimos;
import elo.tech.biblioteca.domain.Livros;
import elo.tech.biblioteca.domain.Usuario;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
public class updateEmprestimoDTO {

    private Long id;
    private Livros livro;
    private Boolean status;
    private Usuario usuario;

}
