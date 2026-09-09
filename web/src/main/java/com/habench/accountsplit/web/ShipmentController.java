package com.habench.accountsplit.web;

import com.habench.accountsplit.web.PaymentNormalizer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountsplitController")
public class ShipmentController {

    @GetMapping("/api/account/split")
    public String normalize(HttpServletRequest request) {
        String filename = request.getHeader("X-Shipment-Reference");
        PaymentNormalizer.publish(filename);
        return "ok";
    }
}
