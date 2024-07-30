package elo.tech.biblioteca.domain.dto;

import elo.tech.biblioteca.domain.Autor;
import elo.tech.biblioteca.domain.Categorias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
public class createLivroDTO {
    private String titulo;

    private String ISBN;

    private LocalDate data_publicacao;

    private List<Categorias> categorias;

    @NotEmpty @NotNull @NotBlank
    private List<Autor> autor = new ArrayList<>();
}
