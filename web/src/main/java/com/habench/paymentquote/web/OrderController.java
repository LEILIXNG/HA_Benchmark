package com.habench.paymentquote.web;

import com.habench.paymentquote.web.OrderTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentquoteController")
public class OrderController {

    @GetMapping("/api/payment/quote")
    public String translate(
            @RequestParam("userName") String userName) {
        OrderTranslator.merge(userName);
        return "ok";
    }
}
