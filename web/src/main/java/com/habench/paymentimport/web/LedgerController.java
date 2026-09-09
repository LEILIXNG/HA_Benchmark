package com.habench.paymentimport.web;

import com.habench.paymentimport.web.RefundGuard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentimportController")
public class LedgerController {

    @GetMapping("/api/payment/import/{label}")
    public String resolve(
            @PathVariable("label") String label) {
        RefundGuard.resolve(label);
        return "ok";
    }
}
