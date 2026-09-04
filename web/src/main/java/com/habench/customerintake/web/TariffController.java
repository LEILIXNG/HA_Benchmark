package com.habench.customerintake.web;

import com.habench.customerintake.web.ManifestGuard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerintakeController")
public class TariffController {

    @GetMapping("/api/customer/intake/{userName}")
    public String merge(
            @PathVariable("userName") String userName) {
        ManifestGuard.resolve(userName);
        return "ok";
    }
}
