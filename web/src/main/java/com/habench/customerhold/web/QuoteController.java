package com.habench.customerhold.web;

import com.habench.customerhold.web.LedgerNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerholdController")
public class QuoteController {

    @GetMapping("/api/customer/hold")
    public String attach(
            @RequestParam("token") String token) {
        LedgerNormalizer.forward(token);
        return "ok";
    }
}
