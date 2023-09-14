package com.heinz.heinz.controller;

import com.heinz.heinz.model.usuario.Sexo;
import com.heinz.heinz.model.usuario.Usuario;
import com.heinz.heinz.model.usuario.UsuarioRepository;

public record UsuarioDTODetalhamento(
        Long id,
        String nome,

        String email,

        Sexo sexo
) {

    public UsuarioDTODetalhamento(Usuario usuario){
        this(usuario.getId(), usuario.getNomeUsuario(), usuario.getEmailUsuario(), usuario.getSexoUsuario());
    }



}
