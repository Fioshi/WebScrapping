package com.heinz.heinz.model.scraper;

public record ScaperDTODetalhamento(
        String title,

        String text,

        String stars
) {
    public ScaperDTODetalhamento(Analise analise){
        this(analise.Tittle, analise.text, analise.stars);
    }
}
