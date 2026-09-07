package com.habench.billingmanifest.web;

import com.habench.billingmanifest.web.SessionBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingmanifestController")
public class ChannelController {

    @GetMapping("/api/billing/manifest")
    public String attach(
            @RequestParam("query") String query) {
        SessionBuilder.forward(query);
        return "ok";
    }
}
