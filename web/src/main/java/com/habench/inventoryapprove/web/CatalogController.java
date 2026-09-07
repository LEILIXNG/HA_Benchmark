package com.habench.inventoryapprove.web;

import com.habench.inventoryapprove.web.ManifestNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryapproveController")
public class CatalogController {

    @GetMapping("/api/inventory/approve/{keyword}")
    public String assemble(
            @PathVariable("keyword") String keyword) {
        ManifestNormalizer.resolve(keyword);
        return "ok";
    }
}
