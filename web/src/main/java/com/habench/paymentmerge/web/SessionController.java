package com.habench.paymentmerge.web;

import com.habench.paymentmerge.web.BundleComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentmergeController")
public class SessionController {

    @GetMapping("/api/payment/merge")
    public String enrich(
            @RequestParam("reference") String reference) {
        BundleComposer.publish(reference);
        return "ok";
    }
}
