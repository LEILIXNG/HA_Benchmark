package com.habench.pricingissue.web;

import com.habench.pricingissue.web.PaymentBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingissueController")
public class BundleController {

    @GetMapping("/api/pricing/issue/{resource}")
    public String attach(
            @PathVariable("resource") String resource) {
        PaymentBuilder.expand(resource);
        return "ok";
    }
}
