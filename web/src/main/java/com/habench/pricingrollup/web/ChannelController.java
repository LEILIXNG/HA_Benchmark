package com.habench.pricingrollup.web;

import com.habench.pricingrollup.web.ShipmentResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingrollupController")
public class ChannelController {

    @GetMapping("/api/pricing/rollup")
    public String refine(
            @RequestParam("keyword") String keyword) {
        ShipmentResolver.stage(keyword);
        return "ok";
    }
}
