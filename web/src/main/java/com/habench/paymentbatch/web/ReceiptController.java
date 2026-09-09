package com.habench.paymentbatch.web;

import com.habench.paymentbatch.web.QuoteAdapter;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentbatchController")
public class ReceiptController {

    @GetMapping("/api/payment/batch")
    public String prepare(
            @CookieValue("receipt_token") String userName) {
        QuoteAdapter.compose(userName);
        return "ok";
    }
}
