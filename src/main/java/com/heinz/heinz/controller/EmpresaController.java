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
@RequestMapping("/api/empresa")
public class EmpresaController {

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    EnderecoService enderecoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid EmpresaDTO dto) {

        var endereco = enderecoService.cadastrar(dto.cepEmpresa());

        var empresa = new Empresa(dto, endereco);

        empresaRepository.save(empresa);

        return ResponseEntity.ok(new EmpresaDTODetalhamento(empresa));
    }

    @GetMapping
    public ResponseEntity listar(){

        var listEmpresa = empresaRepository.findAll();
        LinkedList listDTO = new LinkedList();

        for (Empresa emp:
             listEmpresa) {
            var dto = new EmpresaDTODetalhamentoGet(emp);
            listDTO.add(dto);
        }

        return ResponseEntity.ok(listDTO);
    }
}
