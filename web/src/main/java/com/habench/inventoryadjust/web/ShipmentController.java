package com.habench.inventoryadjust.web;

import com.habench.inventoryadjust.web.ReceiptCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryadjustController")
public class ShipmentController {

    @GetMapping("/api/inventory/adjust")
    public String refine(
            @RequestHeader("X-Shipment-Origin") String orderNo) {
        ReceiptCollector.collect(orderNo);
        return "ok";
    }
}
