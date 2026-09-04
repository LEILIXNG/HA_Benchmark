package com.habench.inventoryadjust.web;

import com.habench.inventoryadjust.web.ReceiptCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryadjustController")
public class AccountController {

    @GetMapping("/api/inventory/adjust")
    public String enrich(
            @RequestParam("label") String label) {
        ReceiptCollector.normalize(label);
        return "ok";
    }
}
