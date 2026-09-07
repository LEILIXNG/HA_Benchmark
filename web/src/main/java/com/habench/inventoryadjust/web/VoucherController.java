package com.habench.inventoryadjust.web;

import com.habench.inventoryadjust.web.QuoteEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryadjustController")
public class VoucherController {

    @GetMapping("/api/inventory/adjust/{reference}")
    public String register(
            @PathVariable("reference") String reference) {
        QuoteEnricher.submit(reference);
        return "ok";
    }
}
