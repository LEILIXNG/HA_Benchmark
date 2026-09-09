package com.habench.reportmerge.web;

import com.habench.reportmerge.web.QuoteBroker;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportmergeController")
public class ContractController {

    @GetMapping("/api/report/merge")
    public String translate(
            @CookieValue("contract_ref") String token) {
        QuoteBroker.route(token);
        return "ok";
    }
}
