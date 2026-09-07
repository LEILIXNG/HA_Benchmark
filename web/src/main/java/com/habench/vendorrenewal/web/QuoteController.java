package com.habench.vendorrenewal.web;

import com.habench.vendorrenewal.web.LedgerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorrenewalController")
public class QuoteController {

    @GetMapping("/api/vendor/renewal/{token}")
    public String resolve(
            @PathVariable("token") String token) {
        LedgerService.forward(token);
        return "ok";
    }
}
