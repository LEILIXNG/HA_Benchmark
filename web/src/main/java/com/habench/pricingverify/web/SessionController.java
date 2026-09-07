package com.habench.pricingverify.web;

import com.habench.pricingverify.web.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingverifyController")
public class SessionController {

    @GetMapping("/api/pricing/verify")
    public String merge(
            @RequestParam("target") String target) {
        OrderService.submit(target);
        return "ok";
    }
}
