package com.habench.billingsync.web;

import com.habench.billingsync.web.ShipmentResolver;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingsyncController")
public class ReceiptController {

    @GetMapping("/api/billing/sync")
    public String refine(
            @CookieValue("receipt_trace") String filename) {
        ShipmentResolver.route(filename);
        return "ok";
    }
}
