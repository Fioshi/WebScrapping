package com.heinz.heinz.model.scraper;

import com.heinz.heinz.model.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Analise {

    String Tittle;

    String text;

    String nome;

    Produto produto;


}
