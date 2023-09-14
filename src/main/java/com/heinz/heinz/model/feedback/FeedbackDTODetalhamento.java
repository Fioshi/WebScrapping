package com.heinz.heinz.model.feedback;

import com.heinz.heinz.model.produto.Produto;
import com.heinz.heinz.model.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record FeedbackDTODetalhamento(

        @NotBlank
        String textoFeedback,

        Produto produto,

        Usuario usuario ) {

        public FeedbackDTODetalhamento(Feedback feedback) {
            this( feedback.getTextoFeedback(), feedback.getProduto(), feedback.getUsuario());
        }
}
