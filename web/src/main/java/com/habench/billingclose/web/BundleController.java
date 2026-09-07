package com.habench.billingclose.web;

import com.habench.billingclose.web.AccountBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingcloseController")
public class BundleController {

    @GetMapping("/api/billing/close")
    public String refine(
            @RequestParam("filename") String filename) {
        AccountBuilder.route(filename);
        return "ok";
    }
}
