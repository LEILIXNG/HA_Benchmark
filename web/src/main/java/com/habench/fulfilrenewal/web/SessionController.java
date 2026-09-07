package com.habench.fulfilrenewal.web;

import com.habench.fulfilrenewal.web.ManifestTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilrenewalController")
public class SessionController {

    @GetMapping("/api/fulfil/renewal/{query}")
    public String stage(
            @PathVariable("query") String query) {
        ManifestTranslator.submit(query);
        return "ok";
    }
}
