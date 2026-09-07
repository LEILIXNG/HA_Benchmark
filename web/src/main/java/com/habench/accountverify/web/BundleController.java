package com.habench.accountverify.web;

import com.habench.accountverify.web.ContractRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountverifyController")
public class BundleController {

    @GetMapping("/api/account/verify/{orderNo}")
    public String merge(
            @PathVariable("orderNo") String orderNo) {
        ContractRegistry.enrich(orderNo);
        return "ok";
    }
}
