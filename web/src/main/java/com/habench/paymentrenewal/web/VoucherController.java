package com.habench.paymentrenewal.web;

import com.habench.paymentrenewal.web.PaymentRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentrenewalController")
public class VoucherController {

    @GetMapping("/api/payment/renewal/{target}")
    public String translate(
            @PathVariable("target") String target) {
        PaymentRouter.collect(target);
        return "ok";
    }
}
