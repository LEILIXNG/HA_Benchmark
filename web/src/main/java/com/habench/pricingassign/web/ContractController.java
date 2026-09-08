package com.habench.pricingassign.web;

import com.habench.pricingassign.web.ManifestNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingassignController")
public class ContractController {

    @GetMapping("/api/pricing/assign")
    public String refine(
            @RequestParam("tag") String tag) {
        ManifestNormalizer.assemble(tag);
        return "ok";
    }
}
