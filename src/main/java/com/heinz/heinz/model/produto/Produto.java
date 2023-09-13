package com.heinz.heinz.model.produto;

import com.heinz.heinz.model.empresa.Empresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_produto")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dtFrabricacaoProduto;

    private String nomeProduto;

    private Double precoProduto;

    private Double notaProduto;

    @ManyToOne
    private Empresa empresa;


    public Produto(ProdutoDTO dto){
        this.dtFrabricacaoProduto = dto.dtFrabricacaoProduto();
        this.nomeProduto = dto.nomeProduto();
        this.precoProduto = dto.precoProduto();
        this.notaProduto = dto.notaProduto();
    }


}
