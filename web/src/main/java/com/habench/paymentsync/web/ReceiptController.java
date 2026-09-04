package com.habench.paymentsync.web;

import com.habench.paymentsync.web.CatalogCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentsyncController")
public class ReceiptController {

    @GetMapping("/api/payment/sync/{keyword}")
    public String prepare(
            @PathVariable("keyword") String keyword) {
        CatalogCollector.resolve(keyword);
        return "ok";
    }
}
