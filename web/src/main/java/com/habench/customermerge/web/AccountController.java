package com.habench.customermerge.web;

import com.habench.customermerge.web.ReceiptCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("customermergeController")
public class AccountController {

    @GetMapping("/api/customer/merge")
    public String prepare(
            @RequestParam("token") String token) {
        ReceiptCoordinator.forward(token);
        return "ok";
    }
}
