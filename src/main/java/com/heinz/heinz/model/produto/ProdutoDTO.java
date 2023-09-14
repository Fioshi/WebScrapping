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

    public ProdutoDTO(Produto produto){
        this(produto.getNomeProduto(), produto.getPrecoProduto(), produto.getEmpresa().getId());
    }
}
