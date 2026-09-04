package com.habench.orderquote.web;

import com.habench.orderquote.web.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderquoteController")
public class BundleController {

    @GetMapping("/api/order/quote/{userName}")
    public String stage(
            @PathVariable("userName") String userName) {
        PaymentService.normalize(userName);
        return "ok";
    }
}
