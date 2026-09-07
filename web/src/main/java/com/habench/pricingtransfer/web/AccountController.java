package com.habench.pricingtransfer.web;

import com.habench.pricingtransfer.web.QuoteBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingtransferController")
public class AccountController {

    @GetMapping("/api/pricing/transfer")
    public String route(
            @RequestParam("reference") String reference) {
        QuoteBuilder.submit(reference);
        return "ok";
    }
}
