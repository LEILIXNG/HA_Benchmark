package com.habench.billingsubmit.web;

import com.habench.billingsubmit.web.InvoiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingsubmitController")
public class OrderController {

    @GetMapping("/api/billing/submit")
    public String compose(
            @RequestParam("tag") String tag) {
        InvoiceService.normalize(tag);
        return "ok";
    }
}
