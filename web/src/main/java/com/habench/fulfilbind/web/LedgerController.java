package com.habench.fulfilbind.web;

import com.habench.fulfilbind.web.ManifestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilbindController")
public class LedgerController {

    @GetMapping("/api/fulfil/bind")
    public String attach(
            @RequestParam("label") String label) {
        ManifestService.stage(label);
        return "ok";
    }
}
