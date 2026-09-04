package com.habench.fulfilverify.web;

import com.habench.fulfilverify.web.QuoteEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilverifyController")
public class InvoiceController {

    @GetMapping("/api/fulfil/verify")
    public String forward(
            @RequestParam("resource") String resource) {
        QuoteEnricher.compose(resource);
        return "ok";
    }
}
