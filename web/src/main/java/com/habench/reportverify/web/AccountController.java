package com.habench.reportverify.web;

import com.habench.reportverify.web.ManifestTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportverifyController")
public class AccountController {

    @GetMapping("/api/report/verify")
    public String enrich(
            @RequestHeader("X-Account-Origin") String tag) {
        ManifestTranslator.reconcile(tag);
        return "ok";
    }
}
