package com.habench.pricingquote.web;

import com.habench.pricingquote.web.InvoiceRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingquoteController")
public class OrderController {

    @GetMapping("/api/pricing/quote/{token}")
    public String forward(
            @PathVariable("token") String token) {
        InvoiceRegistry.enrich(token);
        return "ok";
    }
}
