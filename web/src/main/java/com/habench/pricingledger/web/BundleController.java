package com.habench.pricingledger.web;

import com.habench.pricingledger.web.BundleBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingledgerController")
public class BundleController {

    @GetMapping("/api/pricing/ledger/{token}")
    public String compose(
            @PathVariable("token") String token) {
        BundleBuilder.translate(token);
        return "ok";
    }
}
