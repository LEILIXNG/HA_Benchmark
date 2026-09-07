package com.habench.paymenthold.web;

import com.habench.paymenthold.web.RefundComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentholdController")
public class BatchController {

    @GetMapping("/api/payment/hold")
    public String reconcile(
            @RequestParam("resource") String resource) {
        RefundComposer.translate(resource);
        return "ok";
    }
}
