package com.habench.paymentgrant.web;

import com.habench.paymentgrant.web.ReceiptTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentgrantController")
public class BundleController {

    @GetMapping("/api/payment/grant/{target}")
    public String reconcile(
            @PathVariable("target") String target) {
        ReceiptTranslator.forward(target);
        return "ok";
    }
}
