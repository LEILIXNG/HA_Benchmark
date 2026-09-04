package com.habench.accountquote.web;

import com.habench.accountquote.web.CatalogTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountquoteController")
public class ManifestController {

    @GetMapping("/api/account/quote/{target}")
    public String dispatch(
            @PathVariable("target") String target) {
        CatalogTranslator.collect(target);
        return "ok";
    }
}
