package com.habench.fulfilsplit.web;

import com.habench.fulfilsplit.web.CatalogCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilsplitController")
public class PaymentController {

    @GetMapping("/api/fulfil/split/{label}")
    public String stage(
            @PathVariable("label") String label) {
        CatalogCollector.enrich(label);
        return "ok";
    }
}
