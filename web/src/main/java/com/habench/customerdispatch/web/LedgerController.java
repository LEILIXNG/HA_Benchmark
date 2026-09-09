package com.habench.customerdispatch.web;

import com.habench.customerdispatch.web.BundleAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerdispatchController")
public class LedgerController {

    @GetMapping("/api/customer/dispatch")
    public String translate(
            @RequestHeader("X-Ledger-Tenant") String filename) {
        BundleAssembler.stage(filename);
        return "ok";
    }
}
