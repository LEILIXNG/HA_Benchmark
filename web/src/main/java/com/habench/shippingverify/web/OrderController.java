package com.habench.shippingverify.web;

import com.habench.shippingverify.web.LedgerCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingverifyController")
public class OrderController {

    @GetMapping("/api/shipping/verify")
    public String assemble(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        LedgerCollector.collect(category);
        return "ok";
    }
}
