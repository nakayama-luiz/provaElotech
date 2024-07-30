package elo.tech.biblioteca.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Categorias {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "gen_categoria", sequenceName = "seq_categoria", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column @NotNull @NotBlank
    private String categoria;

    @ManyToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Livros> livros = new ArrayList<>();


}
