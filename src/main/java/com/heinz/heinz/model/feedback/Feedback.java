package com.heinz.heinz.model.feedback;

import com.heinz.heinz.model.produto.Produto;
import com.heinz.heinz.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_feedback")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idFeedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataFeedback;

    private String textoFeedback;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @Column(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    @Column(name = "produto_id")
    private Produto produto;

    public Feedback(FeedbackDTO dto, Produto produto, Usuario usuario) {
        this.dataFeedback = LocalDateTime.now();
        this.textoFeedback = dto.textoFeedback();
        this.usuario = usuario;
        this.produto = produto;
    }
}