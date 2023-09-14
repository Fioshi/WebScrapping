package com.heinz.heinz.controller;

import com.heinz.heinz.model.empresa.EmpresaRepository;
import com.heinz.heinz.model.produto.Produto;
import com.heinz.heinz.model.produto.ProdutoDTO;
import com.heinz.heinz.model.produto.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid ProdutoDTO dto){

        var empresa = empresaRepository.getReferenceById(dto.idEmpresa());
        var produto = new Produto(dto, empresa);

        produtoRepository.save(produto);

        return ResponseEntity.ok(new ProdutoDTO(produto));
    }


}
