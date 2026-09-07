package com.habench.orderrevise.web;

import com.habench.orderrevise.web.PaymentTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderreviseController")
public class BundleController {

    @GetMapping("/api/order/revise/{resource}")
    public String publish(
            @PathVariable("resource") String resource) {
        PaymentTranslator.attach(resource);
        return "ok";
    }
}
