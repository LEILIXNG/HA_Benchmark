package com.habench.customersplit.web;

import com.habench.customersplit.web.VoucherAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("customersplitController")
public class OrderController {

    @GetMapping("/api/customer/split")
    public String attach(
            @RequestParam("category") String category) {
        VoucherAdapter.forward(category);
        return "ok";
    }
}
