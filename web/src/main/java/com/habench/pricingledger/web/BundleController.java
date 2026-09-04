package com.habench.pricingledger.web;

import com.habench.pricingledger.web.BundleBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingledgerController")
public class BundleController {

    @GetMapping("/api/pricing/ledger")
    public String submit(
            @RequestParam("query") String query) {
        BundleBuilder.collect(query);
        return "ok";
    }
}
