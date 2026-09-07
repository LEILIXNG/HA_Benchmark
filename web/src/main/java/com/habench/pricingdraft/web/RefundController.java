package com.habench.pricingdraft.web;

import com.habench.pricingdraft.web.BundleFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingdraftController")
public class RefundController {

    @GetMapping("/api/pricing/draft/{query}")
    public String prepare(
            @PathVariable("query") String query) {
        BundleFacade.reconcile(query);
        return "ok";
    }
}
