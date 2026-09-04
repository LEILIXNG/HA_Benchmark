package com.habench.orderledger.web;

import com.habench.orderledger.web.ContractNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderledgerController")
public class SessionController {

    @GetMapping("/api/order/ledger")
    public String resolve(
            @RequestParam("query") String query) {
        ContractNormalizer.resolve(query);
        return "ok";
    }
}
