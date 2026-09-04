package com.habench.shippingsubmit.web;

import com.habench.shippingsubmit.web.BundleRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingsubmitController")
public class BundleController {

    @GetMapping("/api/shipping/submit")
    public String stage(
            @RequestParam("label") String label) {
        BundleRegistry.attach(label);
        return "ok";
    }
}
