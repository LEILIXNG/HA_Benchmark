package com.habench.accountadjust.web;

import com.habench.accountadjust.web.ContractResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountadjustController")
public class QuoteController {

    @GetMapping("/api/account/adjust")
    public String route(
            @RequestHeader("X-Quote-Reference") String token) {
        ContractResolver.refine(token);
        return "ok";
    }
}
