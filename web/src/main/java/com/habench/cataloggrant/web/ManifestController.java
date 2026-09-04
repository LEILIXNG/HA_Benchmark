package com.habench.cataloggrant.web;

import com.habench.cataloggrant.web.InvoiceBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("cataloggrantController")
public class ManifestController {

    @GetMapping("/api/catalog/grant/{target}")
    public String collect(
            @PathVariable("target") String target) {
        InvoiceBuilder.route(target);
        return "ok";
    }
}
