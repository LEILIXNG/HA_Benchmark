package com.habench.inventoryledger.web;

import com.habench.inventoryledger.web.BatchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryledgerController")
public class PaymentController {

    @GetMapping("/api/inventory/ledger/{keyword}")
    public String collect(
            @PathVariable("keyword") String keyword) {
        BatchService.translate(keyword);
        return "ok";
    }
}
