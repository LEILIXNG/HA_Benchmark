package com.habench.inventoryrenewal.web;

import com.habench.inventoryrenewal.web.ShipmentComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryrenewalController")
public class LedgerController {

    @GetMapping("/api/inventory/renewal")
    public String translate(
            @RequestParam("keyword") String keyword) {
        ShipmentComposer.normalize(keyword);
        return "ok";
    }
}
