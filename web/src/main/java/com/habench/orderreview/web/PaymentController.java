package com.habench.orderreview.web;

import com.habench.orderreview.web.RefundResolver;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderreviewController")
public class PaymentController {

    @GetMapping("/api/order/review")
    public String prepare(
            @CookieValue("payment_trace") String orderNo) {
        RefundResolver.resolve(orderNo);
        return "ok";
    }
}
