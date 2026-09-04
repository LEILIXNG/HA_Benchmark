package com.habench.orderassign.web;

import com.habench.orderassign.web.TariffBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderassignController")
public class ReceiptController {

    @GetMapping("/api/order/assign")
    public String register(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        TariffBuilder.register(reference);
        return "ok";
    }
}
