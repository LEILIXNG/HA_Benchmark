package com.habench.shippingcapture.web;

import com.habench.shippingcapture.web.ManifestBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingcaptureController")
public class ChannelController {

    @GetMapping("/api/shipping/capture")
    public String resolve(
            @RequestParam("keyword") String keyword) {
        ManifestBroker.compose(keyword);
        return "ok";
    }
}
