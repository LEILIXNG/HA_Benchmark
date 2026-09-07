package com.habench.pricingreconcile.web;

import com.habench.pricingreconcile.web.ContractEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingreconcileController")
public class VoucherController {

    @GetMapping("/api/pricing/reconcile")
    public String enrich(
            @RequestParam("userName") String userName) {
        ContractEnricher.dispatch(userName);
        return "ok";
    }
}
