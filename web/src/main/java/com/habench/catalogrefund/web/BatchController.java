package com.habench.catalogrefund.web;

import com.habench.catalogrefund.web.InvoiceEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogrefundController")
public class BatchController {

    @GetMapping("/api/catalog/refund/{target}")
    public String stage(
            @PathVariable("target") String target) {
        InvoiceEnricher.route(target);
        return "ok";
    }
}
