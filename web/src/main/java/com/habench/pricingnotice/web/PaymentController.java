package com.habench.pricingnotice.web;

import com.habench.pricingnotice.web.OrderResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingnoticeController")
public class PaymentController {

    @GetMapping("/api/pricing/notice")
    public String compose(
            @RequestHeader("X-Payment-Context") String tag) {
        OrderResolver.refine(tag);
        return "ok";
    }
}
