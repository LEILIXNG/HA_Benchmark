package com.habench.paymenttrace.web;

import com.habench.paymenttrace.web.BatchBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymenttraceController")
public class SessionController {

    @GetMapping("/api/payment/trace/{label}")
    public String prepare(
            @PathVariable("label") String label) {
        BatchBuilder.attach(label);
        return "ok";
    }
}
