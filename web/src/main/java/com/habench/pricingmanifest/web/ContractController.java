package com.habench.pricingmanifest.web;

import com.habench.pricingmanifest.web.LedgerRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingmanifestController")
public class ContractController {

    @GetMapping("/api/pricing/manifest/{filename}")
    public String register(
            @PathVariable("filename") String filename) {
        LedgerRegistry.stage(filename);
        return "ok";
    }
}
