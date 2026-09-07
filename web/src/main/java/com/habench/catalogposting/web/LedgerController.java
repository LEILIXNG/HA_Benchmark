package com.habench.catalogposting.web;

import com.habench.catalogposting.web.BundleCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogpostingController")
public class LedgerController {

    @GetMapping("/api/catalog/posting/{target}")
    public String forward(
            @PathVariable("target") String target) {
        BundleCoordinator.reconcile(target);
        return "ok";
    }
}
