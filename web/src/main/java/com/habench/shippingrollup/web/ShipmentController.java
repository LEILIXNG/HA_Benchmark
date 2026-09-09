package com.habench.shippingrollup.web;

import com.habench.shippingrollup.web.AccountComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingrollupController")
public class ShipmentController {

    @GetMapping("/api/shipping/rollup")
    public String collect(
            @RequestHeader("X-Shipment-Trace") String orderNo) {
        AccountComposer.attach(orderNo);
        return "ok";
    }
}
