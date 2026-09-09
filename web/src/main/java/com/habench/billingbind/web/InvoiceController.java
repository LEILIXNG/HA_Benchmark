package com.habench.billingbind.web;

import com.habench.billingbind.web.PaymentCollector;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingbindController")
public class InvoiceController {

    @GetMapping("/api/billing/bind")
    public String refine(
            @CookieValue("invoice_ctx") String userName) {
        PaymentCollector.reconcile(userName);
        return "ok";
    }
}
