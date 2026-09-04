package com.habench.pricingbind.web;

import com.habench.pricingbind.web.ReceiptRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingbindController")
public class ReceiptController {

    @GetMapping("/api/pricing/bind/{tag}")
    public String attach(
            @PathVariable("tag") String tag) {
        ReceiptRegistry.stage(tag);
        return "ok";
    }
}
