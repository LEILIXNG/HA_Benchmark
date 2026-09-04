package com.habench.inventorydispatch.web;

import com.habench.inventorydispatch.web.PaymentBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorydispatchController")
public class PaymentController {

    @GetMapping("/api/inventory/dispatch")
    public String translate(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        PaymentBuilder.register(token);
        return "ok";
    }
}
