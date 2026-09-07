package com.habench.paymentnotice.web;

import com.habench.paymentnotice.web.RefundRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentnoticeController")
public class ChannelController {

    @GetMapping("/api/payment/notice")
    public String forward(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        RefundRegistry.submit(category);
        return "ok";
    }
}
