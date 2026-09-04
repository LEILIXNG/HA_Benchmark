package com.habench.vendorbind.web;

import com.habench.vendorbind.web.RefundResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorbindController")
public class RefundController {

    @GetMapping("/api/vendor/bind/{query}")
    public String assemble(
            @PathVariable("query") String query) {
        RefundResolver.register(query);
        return "ok";
    }
}
