package com.heinz.heinz.model.empresa;

public record EmpresaDTODetalhamentoGet(
        Long id,

        String nomeEmpresa
) {
    public EmpresaDTODetalhamentoGet(Empresa empresa){
        this(empresa.getId(), empresa.getNomeEmpresa());
    }
}
