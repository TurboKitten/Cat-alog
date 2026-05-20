package com.example.cat_alog.controler;

import com.example.cat_alog.service.CatAPIService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatAPIControler {

    private final CatAPIService catAPIService;

    public CatAPIControler(CatAPIService catAPIService) {
        this.catAPIService = catAPIService;
    }

    @GetMapping("/gato/random")
    public String gatoRandom() {
        return catAPIService.obtenerGatoRandom();
    }
}