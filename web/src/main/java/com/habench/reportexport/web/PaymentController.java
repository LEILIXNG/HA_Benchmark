package com.habench.reportexport.web;

import com.habench.reportexport.web.ManifestEnricher;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportexportController")
public class PaymentController {

    @GetMapping("/api/report/export")
    public String reconcile(
            @CookieValue("payment_session") String token) {
        ManifestEnricher.reconcile(token);
        return "ok";
    }
}
