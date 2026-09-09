package com.habench.vendordispatch.web;

import com.habench.vendordispatch.web.TariffAdapter;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendordispatchController")
public class TariffController {

    @GetMapping("/api/vendor/dispatch")
    public String enrich(
            @CookieValue("tariff_ref") String filename) {
        TariffAdapter.attach(filename);
        return "ok";
    }
}
