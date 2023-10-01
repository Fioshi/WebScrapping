package com.heinz.heinz.model.scraper;

public record ScaperDTODetalhamento(
        String title,

        String text

) {
    public ScaperDTODetalhamento(Analise analise){
        this(analise.Tittle, analise.text);
    }
}
