package com.habench.shippingquote.web;

import com.habench.shippingquote.web.QuoteBroker;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingquoteController")
public class AccountController {

    @GetMapping("/api/shipping/quote")
    public String expand(
            @CookieValue("account_session") String resource) {
        QuoteBroker.enrich(resource);
        return "ok";
    }
}
