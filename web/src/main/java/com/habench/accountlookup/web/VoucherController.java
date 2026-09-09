package com.habench.accountlookup.web;

import com.habench.accountlookup.web.ContractBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountlookupController")
public class VoucherController {

    @GetMapping("/api/account/lookup/{token}")
    public String submit(
            @PathVariable("token") String token) {
        ContractBroker.collect(token);
        return "ok";
    }
}
