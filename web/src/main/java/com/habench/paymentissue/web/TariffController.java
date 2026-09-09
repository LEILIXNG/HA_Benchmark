package com.habench.paymentissue.web;

import com.habench.paymentissue.web.ManifestCoordinator;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentissueController")
public class TariffController {

    @GetMapping("/api/payment/issue")
    public String forward(
            @CookieValue("tariff_token") String token) {
        ManifestCoordinator.publish(token);
        return "ok";
    }
}
