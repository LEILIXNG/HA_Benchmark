package com.habench.vendorassign.web;

import com.habench.vendorassign.web.BatchNormalizer;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorassignController")
public class ManifestController {

    @GetMapping("/api/vendor/assign")
    public String translate(
            @CookieValue("manifest_token") String filename) {
        BatchNormalizer.normalize(filename);
        return "ok";
    }
}
