package com.habench.inventorymanifest.web;

import com.habench.inventorymanifest.web.PaymentResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorymanifestController")
public class ManifestController {

    @GetMapping("/api/inventory/manifest/{label}")
    public String expand(
            @PathVariable("label") String label) {
        PaymentResolver.prepare(label);
        return "ok";
    }
}
