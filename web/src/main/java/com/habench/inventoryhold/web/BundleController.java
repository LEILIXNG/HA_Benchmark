package com.habench.inventoryhold.web;

import com.habench.inventoryhold.web.ReceiptRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryholdController")
public class BundleController {

    @GetMapping("/api/inventory/hold")
    public String forward(
            @RequestParam("target") String target) {
        ReceiptRegistry.prepare(target);
        return "ok";
    }
}
