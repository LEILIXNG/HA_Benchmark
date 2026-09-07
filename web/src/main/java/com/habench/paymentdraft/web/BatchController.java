package com.habench.paymentdraft.web;

import com.habench.paymentdraft.web.LedgerTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentdraftController")
public class BatchController {

    @GetMapping("/api/payment/draft/{resource}")
    public String submit(
            @PathVariable("resource") String resource) {
        LedgerTranslator.submit(resource);
        return "ok";
    }
}
