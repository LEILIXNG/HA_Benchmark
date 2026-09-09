package com.habench.pricingrevise.web;

import com.habench.pricingrevise.web.BundleEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingreviseController")
public class CatalogController {

    @GetMapping("/api/pricing/revise")
    public String translate(
            @RequestHeader("X-Catalog-Tenant") String target) {
        BundleEnricher.prepare(target);
        return "ok";
    }
}
