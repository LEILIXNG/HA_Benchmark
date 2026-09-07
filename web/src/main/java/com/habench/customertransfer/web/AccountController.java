package com.habench.customertransfer.web;

import com.habench.customertransfer.web.LedgerBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("customertransferController")
public class AccountController {

    @GetMapping("/api/customer/transfer")
    public String enrich(
            @RequestParam("orderNo") String orderNo) {
        LedgerBroker.translate(orderNo);
        return "ok";
    }
}
