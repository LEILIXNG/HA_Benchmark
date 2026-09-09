package com.habench.catalogtransfer.web;

import com.habench.catalogtransfer.web.ContractEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogtransferController")
public class RefundController {

    @GetMapping("/api/catalog/transfer/{keyword}")
    public String collect(
            @PathVariable("keyword") String keyword) {
        ContractEnricher.attach(keyword);
        return "ok";
    }
}
