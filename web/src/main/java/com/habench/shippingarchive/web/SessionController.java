package com.habench.shippingarchive.web;

import com.habench.shippingarchive.web.PaymentRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingarchiveController")
public class SessionController {

    @GetMapping("/api/shipping/archive")
    public String reconcile(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        PaymentRegistry.stage(category);
        return "ok";
    }
}
