package com.habench.paymentreview.web;

import com.habench.paymentreview.web.LedgerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentreviewController")
public class AccountController {

    @GetMapping("/api/payment/review/{keyword}")
    public String refine(
            @PathVariable("keyword") String keyword) {
        LedgerAdapter.stage(keyword);
        return "ok";
    }
}
