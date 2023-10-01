package com.heinz.heinz.controller;

import com.heinz.heinz.model.produto.Produto;
import com.heinz.heinz.model.produto.ProdutoRepository;
import com.heinz.heinz.model.scraper.Analise;
import com.heinz.heinz.model.scraper.Produtos;
import com.heinz.heinz.model.scraper.ScaperDTODetalhamento;
import com.heinz.heinz.model.scraper.ScraperDTO;
import com.heinz.heinz.model.usuario.Usuario;
import com.heinz.heinz.model.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/scraper")
public class WebScrapperController {

    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping
    @Transactional
    @Async
    public ResponseEntity scrapeWebsite(@RequestBody @Valid ScraperDTO dto) throws IOException {

        var url = dto.url();

        Document document = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6"
        ).referrer("http://www.google.com")
                .get();

        Elements spanText = document.select("span.review-text");
        Elements spanTitle = document.select("a.review-title");
        Elements spanName = document.select("a.a-link-normal");
        Elements spanUsuario = document.select("span.a-profile-name");
        var nomeAux = spanName.text().toLowerCase();

        List<Analise> analises = new LinkedList<>();

        for (int i = 0; i < spanText.size(); i++) {

            System.out.println(i);
            String text = spanText.get(i).text();
            String title = spanTitle.get(i).text();

            Analise analise = null;

            if (nomeAux.contains(Produtos.KETCHUP.name().toLowerCase())) {
                var produto = produtoRepository.getReferenceNome(Produtos.KETCHUP.name().toLowerCase());
                analise = new Analise(text, title, Produtos.KETCHUP.name().toLowerCase(), produto.getId());
            }

           if (nomeAux.contains(Produtos.MOSTARDA.name().toLowerCase())) {
               var produto = produtoRepository.getReferenceNome(Produtos.MOSTARDA.name().toLowerCase());
               analise = new Analise(text, title, Produtos.MOSTARDA.name().toLowerCase(), produto.getId());
           }

            if (nomeAux.contains(Produtos.MAIONESE.name().toLowerCase())) {
                var produto = produtoRepository.getReferenceNome(Produtos.MAIONESE.name().toLowerCase());
                analise = new Analise(text, title, Produtos.MAIONESE.name().toLowerCase(), produto.getId());
            }

            analises.add(analise);
        }
        return ResponseEntity.ok(analises);
    }
}


