package com.habench.shippingnotice.web;

import com.habench.shippingnotice.web.AccountAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingnoticeController")
public class ContractController {

    @GetMapping("/api/shipping/notice")
    public String translate(
            @RequestParam("userName") String userName) {
        AccountAdapter.enrich(userName);
        return "ok";
    }
}
