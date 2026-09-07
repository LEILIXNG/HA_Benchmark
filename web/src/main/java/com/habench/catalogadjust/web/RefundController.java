package com.habench.catalogadjust.web;

import com.habench.catalogadjust.web.ContractEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogadjustController")
public class RefundController {

    @GetMapping("/api/catalog/adjust/{keyword}")
    public String collect(
            @PathVariable("keyword") String keyword) {
        ContractEnricher.attach(keyword);
        return "ok";
    }
}
