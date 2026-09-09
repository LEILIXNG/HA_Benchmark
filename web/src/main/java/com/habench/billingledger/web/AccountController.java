package com.habench.billingledger.web;

import com.habench.billingledger.web.ContractAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingledgerController")
public class AccountController {

    @GetMapping("/api/billing/ledger/{filename}")
    public String resolve(
            @PathVariable("filename") String filename) {
        ContractAdapter.collect(filename);
        return "ok";
    }
}
