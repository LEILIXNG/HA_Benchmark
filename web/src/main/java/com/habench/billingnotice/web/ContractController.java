package com.habench.billingnotice.web;

import com.habench.billingnotice.web.ContractAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingnoticeController")
public class ContractController {

    @GetMapping("/api/billing/notice")
    public String merge(
            @RequestHeader("X-Contract-Trace") String userName) {
        ContractAdapter.submit(userName);
        return "ok";
    }
}
