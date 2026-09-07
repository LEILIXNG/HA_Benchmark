package com.habench.customerhold.web;

import com.habench.customerhold.web.TariffBroker2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerholdController")
public class QuoteController {

    @GetMapping("/api/customer/hold")
    public String attach(
            @RequestParam("reference") String reference) {
        TariffBroker2.dispatch(reference);
        return "ok";
    }
}
