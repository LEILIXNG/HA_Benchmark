package com.habench.shippingcapture.web;

import com.habench.shippingcapture.web.RefundRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingcaptureController")
public class ChannelController {

    @GetMapping("/api/shipping/capture")
    public String merge(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        RefundRegistry.route(category);
        return "ok";
    }
}
