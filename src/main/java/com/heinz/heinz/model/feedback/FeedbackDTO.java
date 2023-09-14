package com.heinz.heinz.model.feedback;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record FeedbackDTO(
        @NotNull
        LocalDate dataFeedback,

        @NotBlank
        String textoFeedback,

        Long idProduto,

        Long idUsuario
        ) {
}


