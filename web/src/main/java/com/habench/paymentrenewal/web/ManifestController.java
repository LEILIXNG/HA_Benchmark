package com.habench.paymentrenewal.web;

import com.habench.paymentrenewal.web.ShipmentEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentrenewalController")
public class ManifestController {

    @GetMapping("/api/payment/renewal")
    public String stage(
            @RequestParam("tag") String tag) {
        ShipmentEnricher.forward(tag);
        return "ok";
    }
}
