package com.habench.billingbatch.web;

import com.habench.billingbatch.web.ReceiptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingbatchController")
public class PaymentController {

    @GetMapping("/api/billing/batch/{category}")
    public String compose(
            @PathVariable("category") String category) {
        ReceiptService.submit(category);
        return "ok";
    }
}
