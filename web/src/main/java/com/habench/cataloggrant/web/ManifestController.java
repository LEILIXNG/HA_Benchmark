package com.habench.cataloggrant.web;

import com.habench.cataloggrant.web.TariffNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("cataloggrantController")
public class ManifestController {

    @GetMapping("/api/catalog/grant/{token}")
    public String refine(
            @PathVariable("token") String token) {
        TariffNormalizer.expand(token);
        return "ok";
    }
}
