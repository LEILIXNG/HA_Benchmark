package com.habench.vendormanifest.web;

import com.habench.vendormanifest.web.PaymentCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendormanifestController")
public class SessionController {

    @GetMapping("/api/vendor/manifest")
    public String reconcile(
            @RequestParam("target") String target) {
        PaymentCollector.register(target);
        return "ok";
    }
}
