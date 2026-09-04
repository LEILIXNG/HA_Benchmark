package com.habench.paymentlookup.web;

import com.habench.paymentlookup.web.QuoteAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentlookupController")
public class ChannelController {

    @GetMapping("/api/payment/lookup/{target}")
    public String stage(
            @PathVariable("target") String target) {
        QuoteAdapter.expand(target);
        return "ok";
    }
}
