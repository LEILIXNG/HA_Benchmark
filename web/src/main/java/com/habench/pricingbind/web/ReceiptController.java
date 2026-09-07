package com.habench.pricingbind.web;

import com.habench.pricingbind.web.BundleTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingbindController")
public class ReceiptController {

    @GetMapping("/api/pricing/bind/{filename}")
    public String stage(
            @PathVariable("filename") String filename) {
        BundleTranslator.expand(filename);
        return "ok";
    }
}
