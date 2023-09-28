package com.heinz.heinz.model.endereco;

import jakarta.validation.constraints.NotBlank;

public record EnderecoDTO(

        @NotBlank
        String cep,

        @NotBlank
        String logradouro,

        @NotBlank
        String bairro,

        @NotBlank
        String localidade

) {
        public EnderecoDTO(Endereco endereco) {
                this(endereco.getCep(), endereco.getLogradouro(), endereco.getBairro(), endereco.getLocalidade());
        }
}
