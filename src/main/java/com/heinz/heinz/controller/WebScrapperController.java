package com.heinz.heinz.controller;

import com.heinz.heinz.model.scraper.Analise;
import com.heinz.heinz.model.scraper.ScaperDTODetalhamento;
import com.heinz.heinz.model.scraper.ScraperDTO;
import jakarta.validation.Valid;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/scraper")
public class WebScrapperController {

    @PostMapping
    @Transactional
    @Async
    public ResponseEntity scrapeWebsite(@RequestBody @Valid ScraperDTO dto) throws IOException {

        var url = dto.url();
        // Faz o request para a página e obtém o conteúdo HTML
        Document document = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6"
        ).referrer("http://www.google.com")
                .get();

        // Seleciona todas as tags <span> na página
        Elements spanText = document.select("span.review-text");
        Elements spanTitle = document.select("a.review-title");

        List<Analise> analises = new LinkedList<>();

        // Itera sobre as tags <span> e extrai o texto delas
        for (int i = 0; i < spanText.size(); i++){
            System.out.println(i);
            String text = spanText.get(i).text();
            String title = spanTitle.get(i).text();
//            var title = "Bom";
            var analise = new Analise(text,title);

            analises.add(analise);
        }



        return ResponseEntity.ok(analises);
    }
}


