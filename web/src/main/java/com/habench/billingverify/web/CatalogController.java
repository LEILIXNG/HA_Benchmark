package com.habench.billingverify.web;

import com.habench.billingverify.web.VoucherCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingverifyController")
public class CatalogController {

    @GetMapping("/api/billing/verify")
    public String forward(
            @RequestHeader("X-Catalog-Reference") String category) {
        VoucherCoordinator.prepare(category);
        return "ok";
    }
}
