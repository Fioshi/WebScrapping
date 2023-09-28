package com.heinz.heinz.model.scraper;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ScraperDTO (

        @NotBlank
        String url

){

}
