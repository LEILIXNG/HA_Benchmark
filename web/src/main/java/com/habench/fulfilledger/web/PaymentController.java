package com.habench.fulfilledger.web;

import com.habench.fulfilledger.web.CatalogBuilder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilledgerController")
public class PaymentController {

    @GetMapping("/api/fulfil/ledger")
    public String stage(
            @CookieValue("payment_tag") String userName) {
        CatalogBuilder.attach(userName);
        return "ok";
    }
}
