package com.habench.pricingissue.web;

import com.habench.pricingissue.web.ContractResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingissueController")
public class LedgerController {

    @GetMapping("/api/pricing/issue")
    public String publish(
            @RequestParam("target") String target) {
        ContractResolver.refine(target);
        return "ok";
    }
}
