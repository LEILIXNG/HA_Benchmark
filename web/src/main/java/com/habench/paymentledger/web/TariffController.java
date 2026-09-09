package com.habench.paymentledger.web;

import com.habench.paymentledger.web.AccountCollector;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentledgerController")
public class TariffController {

    @GetMapping("/api/payment/ledger")
    public String reconcile(
            @CookieValue("tariff_tag") String label) {
        AccountCollector.route(label);
        return "ok";
    }
}
