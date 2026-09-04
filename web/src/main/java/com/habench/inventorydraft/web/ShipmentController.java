package com.habench.inventorydraft.web;

import com.habench.inventorydraft.web.PaymentAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorydraftController")
public class ShipmentController {

    @GetMapping("/api/inventory/draft")
    public String route(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        PaymentAssembler.translate(orderNo);
        return "ok";
    }
}
