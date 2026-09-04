package com.habench.shippinglookup.web;

import com.habench.shippinglookup.web.CatalogBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippinglookupController")
public class ReceiptController {

    @GetMapping("/api/shipping/lookup/{reference}")
    public String assemble(
            @PathVariable("reference") String reference) {
        CatalogBuilder.prepare(reference);
        return "ok";
    }
}
