package com.habench.inventoryverify.web;

import com.habench.inventoryverify.web.BundleResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryverifyController")
public class ManifestController {

    @GetMapping("/api/inventory/verify")
    public String translate(
            @RequestParam("resource") String resource) {
        BundleResolver.assemble(resource);
        return "ok";
    }
}
