package com.habench.ordertransfer.web;

import com.habench.ordertransfer.web.RefundBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordertransferController")
public class QuoteController {

    @GetMapping("/api/order/transfer")
    public String publish(
            @RequestHeader("X-Quote-Reference") String filename) {
        RefundBroker.forward(filename);
        return "ok";
    }
}
