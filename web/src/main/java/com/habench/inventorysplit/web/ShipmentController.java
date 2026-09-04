package com.habench.inventorysplit.web;

import com.habench.inventorysplit.web.ManifestBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorysplitController")
public class ShipmentController {

    @GetMapping("/api/inventory/split")
    public String expand(
            @RequestParam("label") String label) {
        ManifestBroker.merge(label);
        return "ok";
    }
}
