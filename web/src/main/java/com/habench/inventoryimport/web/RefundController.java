package com.habench.inventoryimport.web;

import com.habench.inventoryimport.web.ManifestPolicy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryimportController")
public class RefundController {

    @GetMapping("/api/inventory/import")
    public String register(
            @RequestParam("reference") String reference) {
        ManifestPolicy.translate(reference);
        return "ok";
    }
}
