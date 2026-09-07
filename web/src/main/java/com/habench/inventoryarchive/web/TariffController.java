package com.habench.inventoryarchive.web;

import com.habench.inventoryarchive.web.ContractTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryarchiveController")
public class TariffController {

    @GetMapping("/api/inventory/archive")
    public String expand(
            @RequestParam("label") String label) {
        ContractTranslator.reconcile(label);
        return "ok";
    }
}
