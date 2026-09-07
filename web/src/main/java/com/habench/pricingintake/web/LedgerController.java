package com.habench.pricingintake.web;

import com.habench.pricingintake.web.ReceiptResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingintakeController")
public class LedgerController {

    @GetMapping("/api/pricing/intake")
    public String submit(
            @RequestParam("filename") String filename) {
        ReceiptResolver.expand(filename);
        return "ok";
    }
}
