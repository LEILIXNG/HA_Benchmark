package com.habench.paymentreview.web;

import com.habench.paymentreview.web.QuoteRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentreviewController")
public class LedgerController {

    @GetMapping("/api/payment/review/{tag}")
    public String attach(
            @PathVariable("tag") String tag) {
        QuoteRegistry.dispatch(tag);
        return "ok";
    }
}
