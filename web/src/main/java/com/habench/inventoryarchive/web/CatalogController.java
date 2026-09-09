package com.habench.inventoryarchive.web;

import com.habench.inventoryarchive.web.ContractTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryarchiveController")
public class CatalogController {

    @GetMapping("/api/inventory/archive")
    public String prepare(
            @RequestHeader("X-Catalog-Trace") String tag) {
        ContractTranslator.attach(tag);
        return "ok";
    }
}
