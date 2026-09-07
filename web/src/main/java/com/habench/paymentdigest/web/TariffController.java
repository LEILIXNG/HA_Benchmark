package com.habench.paymentdigest.web;

import com.habench.paymentdigest.web.ShipmentResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentdigestController")
public class TariffController {

    @GetMapping("/api/payment/digest/{orderNo}")
    public String collect(
            @PathVariable("orderNo") String orderNo) {
        ShipmentResolver.prepare(orderNo);
        return "ok";
    }
}
