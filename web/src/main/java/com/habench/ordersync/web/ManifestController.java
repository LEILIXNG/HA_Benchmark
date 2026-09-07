package com.habench.ordersync.web;

import com.habench.ordersync.web.ShipmentCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordersyncController")
public class ManifestController {

    @GetMapping("/api/order/sync/{filename}")
    public String submit(
            @PathVariable("filename") String filename) {
        ShipmentCollector.register(filename);
        return "ok";
    }
}
