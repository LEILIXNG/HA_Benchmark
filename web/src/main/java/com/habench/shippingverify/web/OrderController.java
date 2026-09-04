package com.habench.shippingverify.web;

import com.habench.shippingverify.web.TariffRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingverifyController")
public class OrderController {

    @GetMapping("/api/shipping/verify")
    public String translate(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        TariffRegistry.enrich(userName);
        return "ok";
    }
}
