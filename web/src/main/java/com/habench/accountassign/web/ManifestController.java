package com.habench.accountassign.web;

import com.habench.accountassign.web.RefundCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountassignController")
public class ManifestController {

    @GetMapping("/api/account/assign")
    public String enrich(
            @RequestParam("reference") String reference) {
        RefundCollector.route(reference);
        return "ok";
    }
}
