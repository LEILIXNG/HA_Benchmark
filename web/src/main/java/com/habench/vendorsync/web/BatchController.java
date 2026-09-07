package com.habench.vendorsync.web;

import com.habench.vendorsync.web.InvoiceResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorsyncController")
public class BatchController {

    @GetMapping("/api/vendor/sync/{label}")
    public String refine(
            @PathVariable("label") String label) {
        InvoiceResolver.refine(label);
        return "ok";
    }
}
