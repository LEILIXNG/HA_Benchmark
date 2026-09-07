package com.habench.paymentsync.web;

import com.habench.paymentsync.web.ChannelBroker;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentsyncController")
public class ShipmentController {

    @GetMapping("/api/payment/sync")
    public String assemble(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        ChannelBroker.prepare(category);
        return "ok";
    }
}
