package com.habench.paymentcapture.web;

import com.habench.paymentcapture.web.ChannelAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentcaptureController")
public class ShipmentController {

    @GetMapping("/api/payment/capture")
    public String resolve(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        ChannelAssembler.reconcile(filename);
        return "ok";
    }
}
