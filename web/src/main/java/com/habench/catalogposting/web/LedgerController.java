package com.habench.catalogposting.web;

import com.habench.catalogposting.web.QuoteRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogpostingController")
public class LedgerController {

    @GetMapping("/api/catalog/posting/{tag}")
    public String attach(
            @PathVariable("tag") String tag) {
        QuoteRegistry.dispatch(tag);
        return "ok";
    }
}
