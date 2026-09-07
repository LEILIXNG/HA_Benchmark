package com.habench.shippingrevise.web;

import com.habench.shippingrevise.web.LedgerResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingreviseController")
public class PaymentController {

    @GetMapping("/api/shipping/revise/{userName}")
    public String stage(
            @PathVariable("userName") String userName) {
        LedgerResolver.refine(userName);
        return "ok";
    }
}
