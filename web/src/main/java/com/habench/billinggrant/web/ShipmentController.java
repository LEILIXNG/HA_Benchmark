package com.habench.billinggrant.web;

import com.habench.billinggrant.web.PaymentRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billinggrantController")
public class ShipmentController {

    @GetMapping("/api/billing/grant")
    public String submit(HttpServletRequest request) {
        String resource = request.getHeader("X-Shipment-Channel");
        PaymentRouter.translate(resource);
        return "ok";
    }
}
