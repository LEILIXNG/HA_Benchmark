package com.habench.shippinglookup.web;

import com.habench.shippinglookup.web.OrderBroker;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippinglookupController")
public class TariffController {

    @GetMapping("/api/shipping/lookup")
    public String resolve(
            @CookieValue("tariff_ref") String query) {
        OrderBroker.normalize(query);
        return "ok";
    }
}
