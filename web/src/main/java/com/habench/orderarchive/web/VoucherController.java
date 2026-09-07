package com.habench.orderarchive.web;

import com.habench.orderarchive.web.ContractBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderarchiveController")
public class VoucherController {

    @GetMapping("/api/order/archive/{token}")
    public String submit(
            @PathVariable("token") String token) {
        ContractBroker.collect(token);
        return "ok";
    }
}
