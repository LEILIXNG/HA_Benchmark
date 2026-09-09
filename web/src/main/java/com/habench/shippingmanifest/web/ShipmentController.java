package com.habench.shippingmanifest.web;

import com.habench.shippingmanifest.web.AccountEnricher;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingmanifestController")
public class ShipmentController {

    @GetMapping("/api/shipping/manifest")
    public String normalize(
            @CookieValue("shipment_token") String token) {
        AccountEnricher.assemble(token);
        return "ok";
    }
}
