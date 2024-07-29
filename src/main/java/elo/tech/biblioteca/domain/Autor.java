package elo.tech.biblioteca.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Autor {


    @Id
    @SequenceGenerator(allocationSize = 1, name = "gen_autor", sequenceName = "seq_autor", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    private String nome;

    @Column(name = "livros")
    @ManyToMany
    @JsonBackReference
    @JoinTable(
            name = "livro_autor",
            joinColumns = @JoinColumn(name = "autor_id"),
            inverseJoinColumns = @JoinColumn(name = "livros_id")
    )
    private List<Livros> livros= new ArrayList<>();
}
