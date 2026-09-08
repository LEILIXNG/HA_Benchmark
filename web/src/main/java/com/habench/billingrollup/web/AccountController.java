package com.habench.billingrollup.web;

import com.habench.billingrollup.web.ContractCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingrollupController")
public class AccountController {

    @GetMapping("/api/billing/rollup")
    public String submit(
            @RequestParam("orderNo") String orderNo) {
        ContractCollector.compose(orderNo);
        return "ok";
    }
}
