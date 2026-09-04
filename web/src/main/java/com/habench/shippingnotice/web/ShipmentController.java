package com.habench.shippingnotice.web;

import com.habench.shippingnotice.web.ChannelCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingnoticeController")
public class ShipmentController {

    @GetMapping("/api/shipping/notice")
    public String dispatch(
            @RequestParam("token") String token) {
        ChannelCollector.merge(token);
        return "ok";
    }
}
