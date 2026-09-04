package com.habench.catalogissue.web;

import com.habench.catalogissue.web.QuoteResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogissueController")
public class TariffController {

    @GetMapping("/api/catalog/issue")
    public String route(
            @RequestParam("label") String label) {
        QuoteResolver.submit(label);
        return "ok";
    }
}
