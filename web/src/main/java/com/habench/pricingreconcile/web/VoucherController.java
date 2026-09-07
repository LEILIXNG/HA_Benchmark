package com.habench.pricingreconcile.web;

import com.habench.pricingreconcile.web.AccountNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingreconcileController")
public class VoucherController {

    @GetMapping("/api/pricing/reconcile")
    public String publish(
            @RequestParam("filename") String filename) {
        AccountNormalizer.attach(filename);
        return "ok";
    }
}
