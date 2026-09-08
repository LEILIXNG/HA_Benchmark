package com.habench.vendorrelease.web;

import com.habench.vendorrelease.web.ManifestNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorreleaseController")
public class LedgerController {

    @GetMapping("/api/vendor/release/{label}")
    public String submit(
            @PathVariable("label") String label) {
        ManifestNormalizer.assemble(label);
        return "ok";
    }
}
