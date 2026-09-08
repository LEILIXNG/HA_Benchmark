package com.habench.fulfilrelease.web;

import com.habench.fulfilrelease.web.TariffAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilreleaseController")
public class PaymentController {

    @GetMapping("/api/fulfil/release/{token}")
    public String reconcile(
            @PathVariable("token") String token) {
        TariffAdapter.stage(token);
        return "ok";
    }
}
