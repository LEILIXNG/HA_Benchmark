package com.habench.inventoryintake.web;

import com.habench.inventoryintake.web.ShipmentResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryintakeController")
public class ChannelController {

    @GetMapping("/api/inventory/intake")
    public String refine(
            @RequestParam("keyword") String keyword) {
        ShipmentResolver.stage(keyword);
        return "ok";
    }
}
