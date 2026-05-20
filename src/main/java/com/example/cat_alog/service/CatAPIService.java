package com.example.cat_alog.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CatAPIService {

    private final WebClient webClient;

    public CatAPIService(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("https://api.thecatapi.com/v1")
                .build();
    }

    public String obtenerGatoRandom() {

        return webClient.get()
                .uri("/images/search?size=med&mime_types=jpg&format=json&has_breeds=true&limit=1")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}