package com.habench.orderverify.web;

import com.habench.orderverify.web.PaymentBroker;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderverifyController")
public class PaymentController {

    @GetMapping("/api/order/verify")
    public String expand(HttpServletRequest request) {
        String category = request.getHeader("X-Payment-Channel");
        PaymentBroker.expand(category);
        return "ok";
    }
}
