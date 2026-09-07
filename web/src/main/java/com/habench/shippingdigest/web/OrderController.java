package com.habench.shippingdigest.web;

import com.habench.shippingdigest.web.AccountRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingdigestController")
public class OrderController {

    @GetMapping("/api/shipping/digest")
    public String normalize(
            @RequestParam("label") String label) {
        AccountRegistry.merge(label);
        return "ok";
    }
}
