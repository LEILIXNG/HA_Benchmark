package com.habench.billingsubmit.web;

import com.habench.billingsubmit.web.CatalogFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingsubmitController")
public class BatchController {

    @GetMapping("/api/billing/submit/{label}")
    public String reconcile(
            @PathVariable("label") String label) {
        CatalogFacade.reconcile(label);
        return "ok";
    }
}
