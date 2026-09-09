package com.habench.customerledger.web;

import com.habench.customerledger.web.PaymentRegistry;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerledgerController")
public class ShipmentController {

    @GetMapping("/api/customer/ledger")
    public String forward(
            @CookieValue("shipment_session") String token) {
        PaymentRegistry.submit(token);
        return "ok";
    }
}
