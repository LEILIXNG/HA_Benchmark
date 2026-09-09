package com.habench.ordersync.web;

import com.habench.ordersync.web.ManifestComposer;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordersyncController")
public class QuoteController {

    @GetMapping("/api/order/sync")
    public String register(
            @CookieValue("quote_token") String keyword) {
        ManifestComposer.register(keyword);
        return "ok";
    }
}
