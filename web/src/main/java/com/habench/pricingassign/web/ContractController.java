package com.habench.pricingassign.web;

import com.habench.pricingassign.web.ReceiptAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingassignController")
public class ContractController {

    @GetMapping("/api/pricing/assign")
    public String translate(
            @RequestParam("target") String target) {
        ReceiptAdapter.register(target);
        return "ok";
    }
}
