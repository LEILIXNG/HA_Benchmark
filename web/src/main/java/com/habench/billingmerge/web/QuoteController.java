package com.habench.billingmerge.web;

import com.habench.billingmerge.web.PaymentRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingmergeController")
public class QuoteController {

    @GetMapping("/api/billing/merge/{label}")
    public String compose(
            @PathVariable("label") String label) {
        PaymentRegistry.refine(label);
        return "ok";
    }
}
