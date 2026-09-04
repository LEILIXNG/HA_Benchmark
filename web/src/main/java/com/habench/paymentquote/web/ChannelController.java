package com.habench.paymentquote.web;

import com.habench.paymentquote.web.RefundCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentquoteController")
public class ChannelController {

    @GetMapping("/api/payment/quote")
    public String resolve(
            @RequestParam("keyword") String keyword) {
        RefundCollector.route(keyword);
        return "ok";
    }
}
