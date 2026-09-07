package com.habench.paymentledger.web;

import com.habench.paymentledger.web.SessionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentledgerController")
public class BatchController {

    @GetMapping("/api/payment/ledger/{target}")
    public String register(
            @PathVariable("target") String target) {
        SessionService.submit(target);
        return "ok";
    }
}
