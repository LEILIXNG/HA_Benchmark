package com.habench.paymentverify.web;

import com.habench.paymentverify.web.SessionCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentverifyController")
public class TariffController {

    @GetMapping("/api/payment/verify")
    public String enrich(
            @RequestParam("resource") String resource) {
        SessionCoordinator.stage(resource);
        return "ok";
    }
}
