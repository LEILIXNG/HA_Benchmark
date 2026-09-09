package com.habench.vendorquote.web;

import com.habench.vendorquote.web.VoucherBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorquoteController")
public class QuoteController {

    @GetMapping("/api/vendor/quote")
    public String translate(
            @RequestParam("reference") String reference) {
        VoucherBuilder.submit(reference);
        return "ok";
    }
}
