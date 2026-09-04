package com.habench.billingmanifest.web;

import com.habench.billingmanifest.web.OrderResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingmanifestController")
public class ChannelController {

    @GetMapping("/api/billing/manifest/{token}")
    public String expand(
            @PathVariable("token") String token) {
        OrderResolver.expand(token);
        return "ok";
    }
}
