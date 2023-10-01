package com.heinz.heinz.model.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_usuario")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeUsuario;

    private String emailUsuario;

    @Enumerated(EnumType.STRING)
    private Sexo sexoUsuario;

    private LocalDate nascimentoUsuario;

    public Usuario(UsuarioDTO dto) {
        this.nomeUsuario = dto.nomeUsuario();
        this.emailUsuario = dto.emailUsuario();
        this.sexoUsuario = dto.sexoUsuario();
        this.nascimentoUsuario = dto.nascimentoUsuario();
    }

    public Usuario(String nome) {
        this.nomeUsuario = nome;
    }
}
