package com.habench.billingmanifest.web;

import com.habench.billingmanifest.web.ShipmentTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingmanifestController")
public class ChannelController {

    @GetMapping("/api/billing/manifest")
    public String resolve(
            @RequestParam("label") String label) {
        ShipmentTranslator.forward(label);
        return "ok";
    }
}
