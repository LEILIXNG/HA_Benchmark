package com.habench.customermerge.web;

import com.habench.customermerge.web.RefundRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("customermergeController")
public class AccountController {

    @GetMapping("/api/customer/merge")
    public String reconcile(
            @RequestParam("label") String label) {
        RefundRegistry.merge(label);
        return "ok";
    }
}
