package com.habench.paymentrevise.web;

import com.habench.paymentrevise.web.ReceiptEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentreviseController")
public class InvoiceController {

    @GetMapping("/api/payment/revise")
    public String enrich(
            @RequestParam("query") String query) {
        ReceiptEnricher.enrich(query);
        return "ok";
    }
}
