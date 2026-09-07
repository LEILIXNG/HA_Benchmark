package com.habench.billingledger.web;

import com.habench.billingledger.web.SessionFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingledgerController")
public class BundleController {

    @GetMapping("/api/billing/ledger/{tag}")
    public String reconcile(
            @PathVariable("tag") String tag) {
        SessionFacade.attach(tag);
        return "ok";
    }
}
