package com.habench.pricingadjust.web;

import com.habench.pricingadjust.web.InvoiceRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingadjustController")
public class ContractController {

    @GetMapping("/api/pricing/adjust/{token}")
    public String prepare(
            @PathVariable("token") String token) {
        InvoiceRegistry.expand(token);
        return "ok";
    }
}
