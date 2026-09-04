package com.habench.vendorbatch.web;

import com.habench.vendorbatch.web.QuoteBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorbatchController")
public class RefundController {

    @GetMapping("/api/vendor/batch/{reference}")
    public String expand(
            @PathVariable("reference") String reference) {
        QuoteBuilder.dispatch(reference);
        return "ok";
    }
}
