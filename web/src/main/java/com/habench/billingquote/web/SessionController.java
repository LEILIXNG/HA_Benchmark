package com.habench.billingquote.web;

import com.habench.billingquote.web.QuoteNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingquoteController")
public class SessionController {

    @GetMapping("/api/billing/quote/{tag}")
    public String forward(
            @PathVariable("tag") String tag) {
        QuoteNormalizer.submit(tag);
        return "ok";
    }
}
