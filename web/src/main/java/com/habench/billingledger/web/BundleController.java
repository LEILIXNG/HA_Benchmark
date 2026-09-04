package com.habench.billingledger.web;

import com.habench.billingledger.web.SessionNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingledgerController")
public class BundleController {

    @GetMapping("/api/billing/ledger")
    public String route(
            @RequestParam("label") String label) {
        SessionNormalizer.refine(label);
        return "ok";
    }
}
