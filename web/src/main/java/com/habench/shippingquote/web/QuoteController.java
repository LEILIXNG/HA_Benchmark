package com.habench.shippingquote.web;

import com.habench.shippingquote.web.VoucherBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingquoteController")
public class QuoteController {

    @GetMapping("/api/shipping/quote")
    public String translate(
            @RequestParam("reference") String reference) {
        VoucherBuilder.submit(reference);
        return "ok";
    }
}
