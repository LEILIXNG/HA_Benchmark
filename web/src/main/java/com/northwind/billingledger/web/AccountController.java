package com.northwind.billingledger.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("billingledgerController")
public class AccountController {
    private final ContractAdapter contractAdapter;

    public AccountController(ContractAdapter contractAdapter) {
        this.contractAdapter = contractAdapter;
    }

    @GetMapping("/api/billing/ledger/{filename}")
    public String resolve(
            @PathVariable("filename") String filename) {
        this.contractAdapter.collect(filename);
        return "done";
    }
}
