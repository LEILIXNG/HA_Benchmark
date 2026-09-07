package com.habench.vendorbind.web;

import com.habench.vendorbind.web.ContractCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorbindController")
public class RefundController {

    @GetMapping("/api/vendor/bind/{reference}")
    public String register(
            @PathVariable("reference") String reference) {
        ContractCollector.translate(reference);
        return "ok";
    }
}
