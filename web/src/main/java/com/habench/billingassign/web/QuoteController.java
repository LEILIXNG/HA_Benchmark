package com.habench.billingassign.web;

import com.habench.billingassign.web.ManifestAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingassignController")
public class QuoteController {

    @GetMapping("/api/billing/assign")
    public String dispatch(
            @RequestHeader("X-Quote-Client") String token) {
        ManifestAssembler.dispatch(token);
        return "ok";
    }
}
