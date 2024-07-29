package elo.tech.biblioteca.domain;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "emprestimos")
public class Emprestimos {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "gen_emprestimos", sequenceName = "seq_emprestimos", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JoinColumn(name = "livros_id")
    @ManyToOne @NotNull
     private Livros livro;

    @JoinColumn(name = "usuario_id")
    @ManyToOne @NotNull
    private Usuario usuario;

    @Column @PastOrPresent @CreatedDate
    private LocalDate data_emprestimo;

    @Column @Nullable
    private LocalDate data_devolucao;

    @Column @NotNull
    private Boolean status;
}
