package com.heinz.heinz.controller;

import com.heinz.heinz.model.empresa.*;
import com.heinz.heinz.model.endereco.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    EnderecoService enderecoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid EmpresaDTO dto) {

        var endereco = enderecoService.cadastrar(dto.cep());

        var empresa = new Empresa(dto, endereco);

        empresaRepository.save(empresa);

        return ResponseEntity.ok(new EmpresaDTODetalhamento(empresa));
    }

//    @GetMapping
//    public ResponseEntity<Page<EmpresaDTODetalhamento>> listar(@PageableDefault(size = 10, sort = {"nomeEmpresa"}) Pageable paginacao) {
//
//        var page = empresaRepository.findAll(paginacao).map(EmpresaDTODetalhamento::new);
//
//        return ResponseEntity.ok(page);
//    }

    @GetMapping
    public ResponseEntity listar(){

        var list = empresaRepository.findAll();
        LinkedList list1 = new LinkedList();

        for (Empresa emp:
             list) {
            var dto = new EmpresaDTODetalhamentoGet(emp);
        }


        return ResponseEntity.ok(list);
    }
}
