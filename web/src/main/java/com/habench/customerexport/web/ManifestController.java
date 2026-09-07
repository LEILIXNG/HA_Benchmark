package com.habench.customerexport.web;

import com.habench.customerexport.web.BundleCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerexportController")
public class ManifestController {

    @GetMapping("/api/customer/export")
    public String enrich(
            @RequestParam("label") String label) {
        BundleCoordinator.reconcile(label);
        return "ok";
    }
}
