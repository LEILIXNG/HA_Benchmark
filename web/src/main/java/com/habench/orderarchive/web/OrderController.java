package com.habench.orderarchive.web;

import com.habench.orderarchive.web.TariffEnricher;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderarchiveController")
public class OrderController {

    @GetMapping("/api/order/archive")
    public String route(
            @CookieValue("order_ref") String target) {
        TariffEnricher.attach(target);
        return "ok";
    }
}
