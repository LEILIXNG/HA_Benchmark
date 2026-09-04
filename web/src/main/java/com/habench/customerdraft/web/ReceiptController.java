package com.habench.customerdraft.web;

import com.habench.customerdraft.web.PaymentAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerdraftController")
public class ReceiptController {

    @GetMapping("/api/customer/draft")
    public String assemble(
            @RequestParam("resource") String resource) {
        PaymentAdapter.expand(resource);
        return "ok";
    }
}
