package com.habench.inventoryarchive.web;

import com.habench.inventoryarchive.web.ContractBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryarchiveController")
public class TariffController {

    @GetMapping("/api/inventory/archive")
    public String merge(
            @RequestParam("label") String label) {
        ContractBroker.attach(label);
        return "ok";
    }
}
