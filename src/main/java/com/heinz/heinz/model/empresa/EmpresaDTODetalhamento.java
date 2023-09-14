package com.heinz.heinz.model.empresa;

import com.heinz.heinz.model.endereco.Endereco;
import com.heinz.heinz.model.endereco.EnderecoDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmpresaDTODetalhamento(

        @NotNull
        Long id,

        @NotBlank
        String nomeEmpresa,

        @NotBlank
        String cnpjEmpresa,

        EnderecoDTO enderecoEmpresa) {

        public EmpresaDTODetalhamento(Empresa empresa){
            this(empresa.getId(), empresa.getNomeEmpresa(), empresa.getCnpjEmpresa(),
                    new EnderecoDTO(empresa.getEndereco()));
        }

}
