package com.habench.paymentlookup.web;

import com.habench.paymentlookup.web.ManifestBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentlookupController")
public class InvoiceController {

    @GetMapping("/api/payment/lookup")
    public String stage(
            @RequestParam("reference") String reference) {
        ManifestBuilder.expand(reference);
        return "ok";
    }
}
