package com.habench.accountrelease.web;

import com.habench.accountrelease.web.PaymentBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountreleaseController")
public class RefundController {

    @GetMapping("/api/account/release")
    public String register(
            @RequestParam("resource") String resource) {
        PaymentBroker.reconcile(resource);
        return "ok";
    }
}
