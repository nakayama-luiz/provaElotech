package elo.tech.biblioteca.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Usuario {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "gen_user", sequenceName = "seq_user", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    @NotNull @NotBlank
    private String nome;

    @Email @NotNull @NotBlank @Column(unique = true)
    private String email;

    @Column  @CreatedDate
    private LocalDate data_cadastro;

    @Column(unique = true) @Length(min=11, max=11)
    private String telefone;
}
