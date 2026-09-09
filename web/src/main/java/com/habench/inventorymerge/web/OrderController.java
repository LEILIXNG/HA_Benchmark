package com.habench.inventorymerge.web;

import com.habench.inventorymerge.web.AccountRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorymergeController")
public class OrderController {

    @GetMapping("/api/inventory/merge")
    public String normalize(
            @RequestParam("label") String label) {
        AccountRegistry.merge(label);
        return "ok";
    }
}
