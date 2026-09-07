package com.habench.billingdispatch.web;

import com.habench.billingdispatch.web.TariffBroker;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingdispatchController")
public class ChannelController {

    @GetMapping("/api/billing/dispatch")
    public String resolve(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        TariffBroker.register(target);
        return "ok";
    }
}
