package com.habench.paymentarchive.web;

import com.habench.paymentarchive.web.QuoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentarchiveController")
public class TariffController {

    @GetMapping("/api/payment/archive")
    public String prepare(
            @RequestParam("target") String target) {
        QuoteService.translate(target);
        return "ok";
    }
}
