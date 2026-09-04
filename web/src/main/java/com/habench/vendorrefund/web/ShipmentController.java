package com.habench.vendorrefund.web;

import com.habench.vendorrefund.web.ReceiptCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorrefundController")
public class ShipmentController {

    @GetMapping("/api/vendor/refund")
    public String collect(
            @RequestParam("orderNo") String orderNo) {
        ReceiptCollector.collect(orderNo);
        return "ok";
    }
}
