package com.habench.fulfilrevise.web;

import com.habench.fulfilrevise.web.LedgerRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilreviseController")
public class ShipmentController {

    @GetMapping("/api/fulfil/revise/{category}")
    public String submit(
            @PathVariable("category") String category) {
        LedgerRegistry.resolve(category);
        return "ok";
    }
}
