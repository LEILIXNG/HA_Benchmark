package com.habench.pricingmerge.web;

import com.habench.pricingmerge.web.QuoteEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingmergeController")
public class ManifestController {

    @GetMapping("/api/pricing/merge")
    public String resolve(
            @RequestParam("target") String target) {
        QuoteEnricher.publish(target);
        return "ok";
    }
}
