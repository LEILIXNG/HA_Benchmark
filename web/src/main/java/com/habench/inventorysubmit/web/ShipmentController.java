package com.habench.inventorysubmit.web;

import com.habench.inventorysubmit.web.PaymentEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorysubmitController")
public class ShipmentController {

    @GetMapping("/api/inventory/submit")
    public String prepare(
            @RequestParam("category") String category) {
        PaymentEnricher.dispatch(category);
        return "ok";
    }
}
