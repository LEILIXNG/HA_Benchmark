package com.habench.billingarchive.web;

import com.habench.billingarchive.web.SessionGuard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingarchiveController")
public class ShipmentController {

    @GetMapping("/api/billing/archive")
    public String refine(
            @RequestParam("file") String file) {
        SessionGuard.enrich(file);
        return "ok";
    }
}
