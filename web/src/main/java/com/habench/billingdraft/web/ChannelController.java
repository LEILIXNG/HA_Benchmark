package com.habench.billingdraft.web;

import com.habench.billingdraft.web.ShipmentBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingdraftController")
public class ChannelController {

    @GetMapping("/api/billing/draft/{label}")
    public String assemble(
            @PathVariable("label") String label) {
        ShipmentBroker.publish(label);
        return "ok";
    }
}
