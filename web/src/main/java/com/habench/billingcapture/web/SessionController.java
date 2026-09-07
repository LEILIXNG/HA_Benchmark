package com.habench.billingcapture.web;

import com.habench.billingcapture.web.ManifestRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingcaptureController")
public class SessionController {

    @GetMapping("/api/billing/capture/{target}")
    public String collect(
            @PathVariable("target") String target) {
        ManifestRouter.attach(target);
        return "ok";
    }
}
