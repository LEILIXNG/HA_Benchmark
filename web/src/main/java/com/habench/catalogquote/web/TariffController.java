package com.habench.catalogquote.web;

import com.habench.catalogquote.web.QuoteNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogquoteController")
public class TariffController {

    @GetMapping("/api/catalog/quote")
    public String refine(
            @RequestParam("target") String target) {
        QuoteNormalizer.register(target);
        return "ok";
    }
}
