package com.heinz.heinz.model.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UsuarioDTO(
        @NotBlank
        String nomeUsuario,

        @NotBlank
        String emailUsuario,

        @NotNull
        Sexo sexoUsuario,

        @NotNull
        LocalDate nascimentoUsuario

) {
}
