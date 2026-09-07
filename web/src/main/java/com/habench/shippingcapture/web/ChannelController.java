package com.habench.shippingcapture.web;

import com.habench.shippingcapture.web.PaymentBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingcaptureController")
public class ChannelController {

    @GetMapping("/api/shipping/capture")
    public String stage(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        PaymentBuilder.submit(userName);
        return "ok";
    }
}
