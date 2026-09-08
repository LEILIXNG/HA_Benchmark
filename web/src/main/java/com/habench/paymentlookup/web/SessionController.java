package com.habench.paymentlookup.web;

import com.habench.paymentlookup.web.ContractAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentlookupController")
public class SessionController {

    @GetMapping("/api/payment/lookup/{target}")
    public String register(
            @PathVariable("target") String target) {
        ContractAdapter.expand(target);
        return "ok";
    }
}
