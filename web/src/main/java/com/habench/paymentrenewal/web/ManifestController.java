package com.habench.paymentrenewal.web;

import com.habench.paymentrenewal.web.RefundResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentrenewalController")
public class ManifestController {

    @GetMapping("/api/payment/renewal/{userName}")
    public String enrich(
            @PathVariable("userName") String userName) {
        RefundResolver.refine(userName);
        return "ok";
    }
}
