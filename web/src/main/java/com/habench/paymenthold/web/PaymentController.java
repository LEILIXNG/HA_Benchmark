package com.habench.paymenthold.web;

import com.habench.paymenthold.web.SessionRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentholdController")
public class PaymentController {

    @GetMapping("/api/payment/hold/{resource}")
    public String attach(
            @PathVariable("resource") String resource) {
        SessionRouter.merge(resource);
        return "ok";
    }
}
