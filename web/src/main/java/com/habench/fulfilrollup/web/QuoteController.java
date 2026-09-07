package com.habench.fulfilrollup.web;

import com.habench.fulfilrollup.web.LedgerBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilrollupController")
public class QuoteController {

    @GetMapping("/api/fulfil/rollup/{keyword}")
    public String reconcile(
            @PathVariable("keyword") String keyword) {
        LedgerBroker.refine(keyword);
        return "ok";
    }
}
