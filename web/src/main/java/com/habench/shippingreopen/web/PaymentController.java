package com.habench.shippingreopen.web;

import com.habench.shippingreopen.web.InvoiceEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingreopenController")
public class PaymentController {

    @GetMapping("/api/shipping/reopen")
    public String refine(
            @RequestHeader("X-Payment-Tenant") String query) {
        InvoiceEnricher.reconcile(query);
        return "ok";
    }
}
