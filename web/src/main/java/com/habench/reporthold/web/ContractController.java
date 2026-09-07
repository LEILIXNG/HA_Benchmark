package com.habench.reporthold.web;

import com.habench.reporthold.web.BundleRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportholdController")
public class ContractController {

    @GetMapping("/api/report/hold")
    public String reconcile(
            @RequestParam("reference") String reference) {
        BundleRegistry.normalize(reference);
        return "ok";
    }
}
