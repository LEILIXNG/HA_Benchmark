package com.habench.shippingmerge.web;

import com.habench.shippingmerge.web.InvoiceBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingmergeController")
public class AccountController {

    @GetMapping("/api/shipping/merge")
    public String enrich(
            @RequestParam("resource") String resource) {
        InvoiceBroker.refine(resource);
        return "ok";
    }
}
