package com.habench.fulfillookup.web;

import com.habench.fulfillookup.web.BundleBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfillookupController")
public class PaymentController {

    @GetMapping("/api/fulfil/lookup/{category}")
    public String translate(
            @PathVariable("category") String category) {
        BundleBuilder.stage(category);
        return "ok";
    }
}
