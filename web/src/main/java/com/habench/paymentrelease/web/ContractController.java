package com.habench.paymentrelease.web;

import com.habench.paymentrelease.web.QuoteScreen;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentreleaseController")
public class ContractController {

    @GetMapping("/api/payment/release/{filename}")
    public String collect(
            @PathVariable("filename") String filename) {
        QuoteScreen.compose(filename);
        return "ok";
    }
}
