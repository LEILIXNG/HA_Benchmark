package com.habench.billingreconcile.web;

import com.habench.billingreconcile.web.ChannelCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingreconcileController")
public class PaymentController {

    @GetMapping("/api/billing/reconcile/{userName}")
    public String attach(
            @PathVariable("userName") String userName) {
        ChannelCoordinator.merge(userName);
        return "ok";
    }
}
