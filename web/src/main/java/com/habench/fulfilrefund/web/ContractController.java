package com.habench.fulfilrefund.web;

import com.habench.fulfilrefund.web.ManifestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilrefundController")
public class ContractController {

    @GetMapping("/api/fulfil/refund")
    public String enrich(
            @RequestParam("token") String token) {
        ManifestService.enrich(token);
        return "ok";
    }
}
