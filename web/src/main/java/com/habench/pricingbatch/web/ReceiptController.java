package com.habench.pricingbatch.web;

import com.habench.pricingbatch.web.ManifestNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingbatchController")
public class ReceiptController {

    @GetMapping("/api/pricing/batch")
    public String compose(
            @RequestHeader("X-Receipt-Correlation") String category) {
        ManifestNormalizer.attach(category);
        return "ok";
    }
}
