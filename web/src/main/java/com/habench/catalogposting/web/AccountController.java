package com.habench.catalogposting.web;

import com.habench.catalogposting.web.TariffAdapter;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogpostingController")
public class AccountController {

    @GetMapping("/api/catalog/posting")
    public String publish(
            @CookieValue("account_token") String keyword) {
        TariffAdapter.forward(keyword);
        return "ok";
    }
}
