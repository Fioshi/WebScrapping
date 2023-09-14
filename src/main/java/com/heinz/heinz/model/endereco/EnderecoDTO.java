package com.heinz.heinz.model.endereco;

public record EnderecoDTO(
        String logradouro,

        String cep,

        String bairro,
        String localidade,
        String numero
) {
}
