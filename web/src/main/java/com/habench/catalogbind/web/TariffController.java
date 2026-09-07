package com.habench.catalogbind.web;

import com.habench.catalogbind.web.QuoteBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogbindController")
public class TariffController {

    @GetMapping("/api/catalog/bind")
    public String expand(
            @RequestParam("token") String token) {
        QuoteBroker.compose(token);
        return "ok";
    }
}
