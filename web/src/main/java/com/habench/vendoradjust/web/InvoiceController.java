package com.habench.vendoradjust.web;

import com.habench.vendoradjust.web.ReceiptBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendoradjustController")
public class InvoiceController {

    @GetMapping("/api/vendor/adjust")
    public String stage(
            @RequestHeader("X-Invoice-Tenant") String query) {
        ReceiptBuilder.register(query);
        return "ok";
    }
}
