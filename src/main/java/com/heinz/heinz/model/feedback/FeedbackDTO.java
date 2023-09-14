package com.heinz.heinz.model.feedback;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record FeedbackDTO(

        @NotBlank
        String textoFeedback,

        @NotNull
        Long idProduto,

        @NotNull
        Long idUsuario
        ) {
}


