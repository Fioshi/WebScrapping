package com.heinz.heinz.controller;

import com.heinz.heinz.model.empresa.Empresa;
import com.heinz.heinz.model.empresa.EmpresaDTODetalhamentoGet;
import com.heinz.heinz.model.empresa.EmpresaRepository;
import com.heinz.heinz.model.feedback.Feedback;
import com.heinz.heinz.model.feedback.FeedbackRepository;
import com.heinz.heinz.model.produto.Produto;
import com.heinz.heinz.model.produto.ProdutoDTO;
import com.heinz.heinz.model.produto.ProdutoDTODetalhamento;
import com.heinz.heinz.model.produto.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    FeedbackRepository feedbackRepository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid ProdutoDTO dto){

        var empresa = empresaRepository.getReferenceById(dto.idEmpresa());
        var produto = new Produto(dto, empresa);

        produtoRepository.save(produto);

        return ResponseEntity.ok(new ProdutoDTODetalhamento(produto));
    }

    @GetMapping
    public ResponseEntity listar(){

        var listProduto = produtoRepository.findAll();
        LinkedList listDTO = new LinkedList();

        for (Produto prod:
                listProduto) {
            var dto = new ProdutoDTODetalhamento(prod);
            listDTO.add(dto);
        }

        return ResponseEntity.ok(listDTO);
    }

}
