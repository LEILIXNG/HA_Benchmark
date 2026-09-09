package com.habench.pricingquote.web;

import com.habench.pricingquote.web.ContractService;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingquoteController")
public class ContractController {

    @GetMapping("/api/pricing/quote")
    public String attach(
            @CookieValue("contract_ref") String resource) {
        ContractService.expand(resource);
        return "ok";
    }
}
