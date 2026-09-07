package com.habench.billingquote.web;

import com.habench.billingquote.web.ContractNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingquoteController")
public class SessionController {

    @GetMapping("/api/billing/quote/{userName}")
    public String attach(
            @PathVariable("userName") String userName) {
        ContractNormalizer.refine(userName);
        return "ok";
    }
}
