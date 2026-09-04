package com.habench.vendorrelease.web;

import com.habench.vendorrelease.web.ShipmentCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorreleaseController")
public class RefundController {

    @GetMapping("/api/vendor/release/{target}")
    public String reconcile(
            @PathVariable("target") String target) {
        ShipmentCollector.publish(target);
        return "ok";
    }
}
