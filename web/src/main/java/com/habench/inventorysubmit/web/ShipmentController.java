package com.habench.inventorysubmit.web;

import com.habench.inventorysubmit.web.OrderComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorysubmitController")
public class ShipmentController {

    @GetMapping("/api/inventory/submit")
    public String stage(
            @RequestParam("orderNo") String orderNo) {
        OrderComposer.register(orderNo);
        return "ok";
    }
}
