package com.habench.inventorydigest.web;

import com.habench.inventorydigest.web.LedgerEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorydigestController")
public class AccountController {

    @GetMapping("/api/inventory/digest/{resource}")
    public String enrich(
            @PathVariable("resource") String resource) {
        LedgerEnricher.refine(resource);
        return "ok";
    }
}
