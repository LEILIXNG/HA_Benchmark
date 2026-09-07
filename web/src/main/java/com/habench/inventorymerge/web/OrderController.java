package com.habench.inventorymerge.web;

import com.habench.inventorymerge.web.QuoteAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorymergeController")
public class OrderController {

    @GetMapping("/api/inventory/merge/{token}")
    public String publish(
            @PathVariable("token") String token) {
        QuoteAdapter.stage(token);
        return "ok";
    }
}
