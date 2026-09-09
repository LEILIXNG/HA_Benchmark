package com.habench.vendorintake.web;

import com.habench.vendorintake.web.AccountTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorintakeController")
public class QuoteController {

    @GetMapping("/api/vendor/intake")
    public String assemble(
            @RequestHeader("X-Quote-Correlation") String resource) {
        AccountTranslator.forward(resource);
        return "ok";
    }
}
