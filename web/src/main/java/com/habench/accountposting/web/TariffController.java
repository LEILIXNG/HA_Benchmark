package com.habench.accountposting.web;

import com.habench.accountposting.web.PaymentBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountpostingController")
public class TariffController {

    @GetMapping("/api/account/posting")
    public String enrich(
            @RequestParam("label") String label) {
        PaymentBuilder.resolve(label);
        return "ok";
    }
}
