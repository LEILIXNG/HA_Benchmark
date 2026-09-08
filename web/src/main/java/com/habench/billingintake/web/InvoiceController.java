package com.habench.billingintake.web;

import com.habench.billingintake.web.ContractService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingintakeController")
public class InvoiceController {

    @GetMapping("/api/billing/intake")
    public String route(
            @RequestParam("label") String label) {
        ContractService.compose(label);
        return "ok";
    }
}
