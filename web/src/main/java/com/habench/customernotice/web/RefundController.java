package com.habench.customernotice.web;

import com.habench.customernotice.web.ReceiptRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("customernoticeController")
public class RefundController {

    @GetMapping("/api/customer/notice")
    public String route(
            @RequestParam("target") String target) {
        ReceiptRegistry.forward(target);
        return "ok";
    }
}
