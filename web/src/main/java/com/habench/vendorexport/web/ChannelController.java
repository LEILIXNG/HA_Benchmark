package com.habench.vendorexport.web;

import com.habench.vendorexport.web.ShipmentResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorexportController")
public class ChannelController {

    @GetMapping("/api/vendor/export")
    public String refine(
            @RequestParam("keyword") String keyword) {
        ShipmentResolver.stage(keyword);
        return "ok";
    }
}
