package com.heinz.heinz.controller;

import com.heinz.heinz.model.empresa.Empresa;
import com.heinz.heinz.model.empresa.EmpresaDTO;
import com.heinz.heinz.model.empresa.EmpresaDTODetalhamento;
import com.heinz.heinz.model.empresa.EmpresaRepository;
import com.heinz.heinz.model.endereco.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
