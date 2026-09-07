package com.habench.shippingledger.web;

import com.habench.shippingledger.web.ShipmentAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingledgerController")
public class BatchController {

    @GetMapping("/api/shipping/ledger")
    public String publish(
            @RequestParam("resource") String resource) {
        ShipmentAdapter.merge(resource);
        return "ok";
    }
}
