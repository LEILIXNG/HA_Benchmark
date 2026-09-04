package com.habench.accountmerge.web;

import com.habench.accountmerge.web.RefundGuard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountmergeController")
public class OrderController {

    @GetMapping("/api/account/merge")
    public String enrich(
            @RequestParam("query") String query) {
        RefundGuard.submit(query);
        return "ok";
    }
}
