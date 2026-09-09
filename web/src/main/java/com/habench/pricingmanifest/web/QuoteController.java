package com.habench.pricingmanifest.web;

import com.habench.pricingmanifest.web.CatalogEnricher;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingmanifestController")
public class QuoteController {

    @GetMapping("/api/pricing/manifest")
    public String enrich(
            @CookieValue("quote_trace") String label) {
        CatalogEnricher.stage(label);
        return "ok";
    }
}
