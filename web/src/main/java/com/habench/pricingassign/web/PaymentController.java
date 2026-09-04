package com.habench.pricingassign.web;

import com.habench.pricingassign.web.LedgerNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingassignController")
public class PaymentController {

    @GetMapping("/api/pricing/assign")
    public String register(
            @RequestParam("query") String query) {
        LedgerNormalizer.reconcile(query);
        return "ok";
    }
}
