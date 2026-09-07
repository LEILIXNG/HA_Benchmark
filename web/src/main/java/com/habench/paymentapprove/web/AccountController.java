package com.habench.paymentapprove.web;

import com.habench.paymentapprove.web.OrderCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentapproveController")
public class AccountController {

    @GetMapping("/api/payment/approve")
    public String submit(
            @RequestParam("tag") String tag) {
        OrderCollector.assemble(tag);
        return "ok";
    }
}
