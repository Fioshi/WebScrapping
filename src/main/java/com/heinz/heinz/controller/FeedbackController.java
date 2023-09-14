package com.heinz.heinz.controller;

import com.heinz.heinz.model.feedback.Feedback;
import com.heinz.heinz.model.feedback.FeedbackDTO;
import com.heinz.heinz.model.feedback.FeedbackDTODetalhamento;
import com.heinz.heinz.model.feedback.FeedbackRepository;
import com.heinz.heinz.model.produto.ProdutoRepository;
import com.heinz.heinz.model.usuario.Usuario;
import com.heinz.heinz.model.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid FeedbackDTO dto){

        var produto = produtoRepository.getReferenceById(dto.idProduto());
        var usuario = usuarioRepository.getReferenceById(dto.idUsuario());

        var feedback = new Feedback(dto, produto, usuario);

        feedbackRepository.save(feedback);

        return ResponseEntity.ok(new FeedbackDTODetalhamento(feedback));
    }


}
