package com.habench.billingrevise.web;

import com.habench.billingrevise.web.ReceiptEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingreviseController")
public class ChannelController {

    @GetMapping("/api/billing/revise/{label}")
    public String assemble(
            @PathVariable("label") String label) {
        ReceiptEnricher.resolve(label);
        return "ok";
    }
}
