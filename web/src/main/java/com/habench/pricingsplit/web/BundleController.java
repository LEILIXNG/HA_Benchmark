package com.habench.pricingsplit.web;

import com.habench.pricingsplit.web.ContractComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingsplitController")
public class BundleController {

    @GetMapping("/api/pricing/split/{tag}")
    public String translate(
            @PathVariable("tag") String tag) {
        ContractComposer.stage(tag);
        return "ok";
    }
}
