package com.habench.paymentsplit.web;

import com.habench.paymentsplit.web.BatchAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentsplitController")
public class RefundController {

    @GetMapping("/api/payment/split")
    public String compose(
            @RequestParam("reference") String reference) {
        BatchAssembler.enrich(reference);
        return "ok";
    }
}
