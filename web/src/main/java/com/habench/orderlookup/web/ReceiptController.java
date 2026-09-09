package com.habench.orderlookup.web;

import com.habench.orderlookup.web.AccountBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderlookupController")
public class ReceiptController {

    @GetMapping("/api/order/lookup")
    public String normalize(
            @RequestHeader("X-Receipt-Correlation") String target) {
        AccountBroker.expand(target);
        return "ok";
    }
}
