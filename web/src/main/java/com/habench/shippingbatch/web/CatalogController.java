package com.habench.shippingbatch.web;

import com.habench.shippingbatch.web.LedgerTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingbatchController")
public class CatalogController {

    @GetMapping("/api/shipping/batch/{label}")
    public String route(
            @PathVariable("label") String label) {
        LedgerTranslator.route(label);
        return "ok";
    }
}
