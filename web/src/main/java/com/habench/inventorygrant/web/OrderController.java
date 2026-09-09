package com.habench.inventorygrant.web;

import com.habench.inventorygrant.web.AccountBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorygrantController")
public class OrderController {

    @GetMapping("/api/inventory/grant")
    public String prepare(
            @RequestHeader("X-Order-Tenant") String label) {
        AccountBuilder.register(label);
        return "ok";
    }
}
