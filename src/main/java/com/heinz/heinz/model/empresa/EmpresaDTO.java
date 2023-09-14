package com.heinz.heinz.model.empresa;

import jakarta.validation.constraints.NotBlank;

public record EmpresaDTO(

        @NotBlank
        String nomeEmpresa,

        @NotBlank
        String sedeEmpresa,

        @NotBlank
        String cnpjEmpresa,

        String cep
        ) {
//    public EmpresaDTO(Empresa empresa) {
//        this(empresa.getNomeEmpresa(), empresa.getSedeEmpresa(), empresa.getCnpjEmpresa());
//    }
}
