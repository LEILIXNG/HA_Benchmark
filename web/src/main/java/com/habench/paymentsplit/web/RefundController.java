package com.habench.paymentsplit.web;

import com.habench.paymentsplit.web.BatchCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentsplitController")
public class RefundController {

    @GetMapping("/api/payment/split")
    public String assemble(
            @RequestParam("label") String label) {
        BatchCoordinator.collect(label);
        return "ok";
    }
}
