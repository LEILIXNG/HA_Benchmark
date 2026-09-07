package com.habench.paymentdraft.web;

import com.habench.paymentdraft.web.ReceiptComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentdraftController")
public class BatchController {

    @GetMapping("/api/payment/draft/{keyword}")
    public String stage(
            @PathVariable("keyword") String keyword) {
        ReceiptComposer.merge(keyword);
        return "ok";
    }
}
