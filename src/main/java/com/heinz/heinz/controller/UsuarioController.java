package com.heinz.heinz.controller;

import com.heinz.heinz.model.usuario.Usuario;
import com.heinz.heinz.model.usuario.UsuarioDTO;
import com.heinz.heinz.model.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid UsuarioDTO dto){

        var usuario = new Usuario(dto);

        usuarioRepository.save(usuario);

        return ResponseEntity.ok(new UsuarioDTODetalhamento(usuario));
    }


}
