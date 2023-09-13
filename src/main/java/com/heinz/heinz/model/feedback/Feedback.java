package com.heinz.heinz.model.feedback;

import com.heinz.heinz.model.produto.Produto;
import com.heinz.heinz.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_feedback")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idFeedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFeedback;

    private LocalDate dataFeedback;

    private String textoFeedback;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Produto produto;
}
