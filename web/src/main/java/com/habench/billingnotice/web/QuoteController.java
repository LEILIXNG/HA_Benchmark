package com.habench.billingnotice.web;

import com.habench.billingnotice.web.ContractCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingnoticeController")
public class QuoteController {

    @GetMapping("/api/billing/notice")
    public String normalize(
            @RequestParam("tag") String tag) {
        ContractCoordinator.expand(tag);
        return "ok";
    }
}
