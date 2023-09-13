package com.heinz.heinz.model.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ProdutoDTO(
        @NotNull
        LocalDate dtFrabricacaoProduto,

        @NotBlank
        String nomeProduto,

        @NotNull
        Double precoProduto,

        @NotNull
        Double notaProduto) {

    public ProdutoDTO(Produto produto){
        this(produto.getDtFrabricacaoProduto(), produto.getNomeProduto(), produto.getPrecoProduto(), produto.getNotaProduto());
    }
}
