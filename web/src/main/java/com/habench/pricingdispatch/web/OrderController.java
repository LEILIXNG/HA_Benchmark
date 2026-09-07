package com.habench.pricingdispatch.web;

import com.habench.pricingdispatch.web.ReceiptComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingdispatchController")
public class OrderController {

    @GetMapping("/api/pricing/dispatch")
    public String prepare(
            @RequestParam("reference") String reference) {
        ReceiptComposer.refine(reference);
        return "ok";
    }
}
