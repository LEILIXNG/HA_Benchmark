package com.habench.billingbatch.web;

import com.habench.billingbatch.web.AccountComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingbatchController")
public class PaymentController {

    @GetMapping("/api/billing/batch/{userName}")
    public String normalize(
            @PathVariable("userName") String userName) {
        AccountComposer.resolve(userName);
        return "ok";
    }
}
