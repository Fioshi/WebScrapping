package com.heinz.heinz.model.feedback;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record FeedbackDTO(
        @NotNull
        LocalDate dataFeedback,

        @NotBlank
        String textoFeedback) {

        public FeedbackDTO (Feedback feedback){
                this(feedback.getDataFeedback(), feedback.getTextoFeedback());
        }
}


