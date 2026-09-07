package com.habench.billingbind.web;

import com.habench.billingbind.web.CatalogCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingbindController")
public class ReceiptController {

    @GetMapping("/api/billing/bind")
    public String translate(
            @RequestParam("resource") String resource) {
        CatalogCoordinator.expand(resource);
        return "ok";
    }
}
