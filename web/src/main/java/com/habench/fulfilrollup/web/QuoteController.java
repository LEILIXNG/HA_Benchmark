package com.habench.fulfilrollup.web;

import com.habench.fulfilrollup.web.LedgerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilrollupController")
public class QuoteController {

    @GetMapping("/api/fulfil/rollup/{filename}")
    public String refine(
            @PathVariable("filename") String filename) {
        LedgerAdapter.refine(filename);
        return "ok";
    }
}
