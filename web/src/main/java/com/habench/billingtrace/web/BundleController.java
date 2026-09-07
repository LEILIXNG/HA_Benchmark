package com.habench.billingtrace.web;

import com.habench.billingtrace.web.PaymentBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingtraceController")
public class BundleController {

    @GetMapping("/api/billing/trace/{userName}")
    public String forward(
            @PathVariable("userName") String userName) {
        PaymentBuilder.compose(userName);
        return "ok";
    }
}
