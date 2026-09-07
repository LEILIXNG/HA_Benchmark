package com.habench.orderlookup.web;

import com.habench.orderlookup.web.RefundGuard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderlookupController")
public class LedgerController {

    @GetMapping("/api/order/lookup/{label}")
    public String resolve(
            @PathVariable("label") String label) {
        RefundGuard.resolve(label);
        return "ok";
    }
}
