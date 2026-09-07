package com.habench.billingrollup.web;

import com.habench.billingrollup.web.InvoiceBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingrollupController")
public class OrderController {

    @GetMapping("/api/billing/rollup")
    public String merge(
            @RequestParam("label") String label) {
        InvoiceBuilder.assemble(label);
        return "ok";
    }
}
