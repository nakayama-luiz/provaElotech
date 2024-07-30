package elo.tech.biblioteca.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Livros {


    @Id
    @SequenceGenerator(allocationSize = 1, name = "gen_livro", sequenceName = "seq_livro", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull @NotBlank @ISBN @Column(unique = true) @JsonProperty("ISBN")
    private String ISBN;

    @Column @PastOrPresent
    private LocalDate data_publicacao;

    @Column @NotBlank @NotNull
    private String titulo;

//    @Enumerated(EnumType.STRING)
//    @ElementCollection
//    @NotNull @NotEmpty
//    private List<Categoria> categorias;

    @ManyToMany
    @JoinTable(
            name = "livros_categorias",
            joinColumns = @JoinColumn(name = "livros_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categorias> categoria = new ArrayList<>();

    @ManyToMany(mappedBy = "livros")
    private List<Autor> autor = new ArrayList<>();

}
