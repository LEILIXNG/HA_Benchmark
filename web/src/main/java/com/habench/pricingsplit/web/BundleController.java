package com.habench.pricingsplit.web;

import com.habench.pricingsplit.web.AccountTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingsplitController")
public class BundleController {

    @GetMapping("/api/pricing/split")
    public String submit(
            @RequestParam("reference") String reference) {
        AccountTranslator.attach(reference);
        return "ok";
    }
}
