package com.habench.customerrenewal.web;

import com.habench.customerrenewal.web.LedgerEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerrenewalController")
public class QuoteController {

    @GetMapping("/api/customer/renewal")
    public String publish(
            @RequestParam("userName") String userName) {
        LedgerEnricher.merge(userName);
        return "ok";
    }
}
