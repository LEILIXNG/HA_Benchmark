package com.habench.paymentsubmit.web;

import com.habench.paymentsubmit.web.PaymentAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentsubmitController")
public class SessionController {

    @GetMapping("/api/payment/submit")
    public String compose(
            @RequestParam("userName") String userName) {
        PaymentAssembler.enrich(userName);
        return "ok";
    }
}
