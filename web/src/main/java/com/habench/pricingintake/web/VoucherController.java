package com.habench.pricingintake.web;

import com.habench.pricingintake.web.BundleComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingintakeController")
public class VoucherController {

    @GetMapping("/api/pricing/intake")
    public String forward(
            @RequestParam("label") String label) {
        BundleComposer.publish(label);
        return "ok";
    }
}
