package com.habench.pricingexport.web;

import com.habench.pricingexport.web.InvoiceBroker;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingexportController")
public class AccountController {

    @GetMapping("/api/pricing/export")
    public String route(
            @CookieValue("account_ctx") String category) {
        InvoiceBroker.assemble(category);
        return "ok";
    }
}
