package com.habench.billinglookup.web;

import com.habench.billinglookup.web.ContractTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("billinglookupController")
public class AccountController {

    @GetMapping("/api/billing/lookup/{label}")
    public String enrich(
            @PathVariable("label") String label) {
        ContractTranslator.submit(label);
        return "ok";
    }
}
