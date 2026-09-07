package com.habench.vendorrevise.web;

import com.habench.vendorrevise.web.LedgerRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorreviseController")
public class OrderController {

    @GetMapping("/api/vendor/revise/{keyword}")
    public String reconcile(
            @PathVariable("keyword") String keyword) {
        LedgerRegistry.reconcile(keyword);
        return "ok";
    }
}
