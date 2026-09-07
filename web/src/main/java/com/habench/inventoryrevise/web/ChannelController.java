package com.habench.inventoryrevise.web;

import com.habench.inventoryrevise.web.PaymentBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryreviseController")
public class ChannelController {

    @GetMapping("/api/inventory/revise")
    public String route(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        PaymentBuilder.register(reference);
        return "ok";
    }
}
