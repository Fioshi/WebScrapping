package com.heinz.heinz.model.empresa;

import com.heinz.heinz.model.endereco.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmpresaDTODetalhamento(

        @NotNull
        Long id,

        @NotBlank
        String nomeEmpresa,

        @NotBlank
        String sedeEmpresa,

        @NotBlank
        String cnpjEmpresa,

        Endereco endereco) {

        public EmpresaDTODetalhamento(Empresa empresa){
            this(empresa.getId(), empresa.getNomeEmpresa(), empresa.getSedeEmpresa(), empresa.getNomeEmpresa(), empresa.getEndereco());
        }

}
