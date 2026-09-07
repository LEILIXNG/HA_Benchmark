package com.habench.orderarchive.web;

import com.habench.orderarchive.web.PaymentComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderarchiveController")
public class OrderController {

    @GetMapping("/api/order/archive")
    public String enrich(
            @RequestParam("target") String target) {
        PaymentComposer.compose(target);
        return "ok";
    }
}
