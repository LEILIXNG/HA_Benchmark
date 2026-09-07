package com.habench.billingreconcile.web;

import com.habench.billingreconcile.web.OrderResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingreconcileController")
public class PaymentController {

    @GetMapping("/api/billing/reconcile")
    public String expand(
            @RequestParam("label") String label) {
        OrderResolver.translate(label);
        return "ok";
    }
}
