package com.habench.pricinghold.web;

import com.habench.pricinghold.web.CatalogFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingholdController")
public class BatchController {

    @GetMapping("/api/pricing/hold/{label}")
    public String reconcile(
            @PathVariable("label") String label) {
        CatalogFacade.reconcile(label);
        return "ok";
    }
}
