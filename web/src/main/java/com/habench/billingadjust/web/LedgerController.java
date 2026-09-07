package com.habench.billingadjust.web;

import com.habench.billingadjust.web.QuoteAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingadjustController")
public class LedgerController {

    @GetMapping("/api/billing/adjust")
    public String submit(
            @RequestParam("filename") String filename) {
        QuoteAssembler.publish(filename);
        return "ok";
    }
}
