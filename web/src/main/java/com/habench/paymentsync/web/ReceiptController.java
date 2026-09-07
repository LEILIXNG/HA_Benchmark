package com.habench.paymentsync.web;

import com.habench.paymentsync.web.ContractRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentsyncController")
public class ReceiptController {

    @GetMapping("/api/payment/sync/{query}")
    public String register(
            @PathVariable("query") String query) {
        ContractRegistry.register(query);
        return "ok";
    }
}
