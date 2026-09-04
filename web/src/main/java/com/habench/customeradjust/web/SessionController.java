package com.habench.customeradjust.web;

import com.habench.customeradjust.web.QuoteBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customeradjustController")
public class SessionController {

    @GetMapping("/api/customer/adjust/{orderNo}")
    public String collect(
            @PathVariable("orderNo") String orderNo) {
        QuoteBuilder.expand(orderNo);
        return "ok";
    }
}
