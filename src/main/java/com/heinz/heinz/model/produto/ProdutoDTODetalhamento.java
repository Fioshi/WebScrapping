package com.heinz.heinz.model.produto;

public record ProdutoDTODetalhamento(
        Long id,

        String nome,

        Double preco
) {
    public ProdutoDTODetalhamento(Produto produto){
        this(produto.getId(), produto.getNomeProduto(), produto.getPrecoProduto());
    }
}
