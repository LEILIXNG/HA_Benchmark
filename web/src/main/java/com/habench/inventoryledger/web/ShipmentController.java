package com.habench.inventoryledger.web;

import com.habench.inventoryledger.web.PaymentRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryledgerController")
public class ShipmentController {

    @GetMapping("/api/inventory/ledger")
    public String submit(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        PaymentRouter.translate(resource);
        return "ok";
    }
}
