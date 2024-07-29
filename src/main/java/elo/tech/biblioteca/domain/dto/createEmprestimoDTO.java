package elo.tech.biblioteca.domain.dto;

import elo.tech.biblioteca.domain.Livros;
import elo.tech.biblioteca.domain.Usuario;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
public class createEmprestimoDTO {

    private Usuario usuario;

    private Livros livro;


}
