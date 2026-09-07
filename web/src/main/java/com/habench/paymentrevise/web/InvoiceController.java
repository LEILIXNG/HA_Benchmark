package com.habench.paymentrevise.web;

import com.habench.paymentrevise.web.VoucherTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentreviseController")
public class InvoiceController {

    @GetMapping("/api/payment/revise")
    public String dispatch(
            @RequestParam("query") String query) {
        VoucherTranslator.translate(query);
        return "ok";
    }
}
