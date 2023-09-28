package com.heinz.heinz.model.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ProdutoDTO(

        @NotBlank
        String nomeProduto,

        @NotNull
        Double precoProduto,

        @NotNull
        Long idEmpresa
) {
}
