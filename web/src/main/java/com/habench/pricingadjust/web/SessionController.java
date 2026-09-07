package com.habench.pricingadjust.web;

import com.habench.pricingadjust.web.QuoteBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingadjustController")
public class SessionController {

    @GetMapping("/api/pricing/adjust/{orderNo}")
    public String reconcile(
            @PathVariable("orderNo") String orderNo) {
        QuoteBuilder.compose(orderNo);
        return "ok";
    }
}
