package com.habench.paymentassign.web;

import com.habench.paymentassign.web.PaymentEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentassignController")
public class RefundController {

    @GetMapping("/api/payment/assign")
    public String submit(
            @RequestParam("tag") String tag) {
        PaymentEnricher.register(tag);
        return "ok";
    }
}
