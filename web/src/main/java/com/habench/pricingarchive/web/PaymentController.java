package com.habench.pricingarchive.web;

import com.habench.pricingarchive.web.QuoteRouter;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingarchiveController")
public class PaymentController {

    @GetMapping("/api/pricing/archive")
    public String collect(
            @CookieValue("payment_ref") String target) {
        QuoteRouter.publish(target);
        return "ok";
    }
}
