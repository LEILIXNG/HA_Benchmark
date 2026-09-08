package com.habench.paymentissue.web;

import com.habench.paymentissue.web.SessionCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentissueController")
public class TariffController {

    @GetMapping("/api/payment/issue")
    public String enrich(
            @RequestParam("resource") String resource) {
        SessionCoordinator.stage(resource);
        return "ok";
    }
}
