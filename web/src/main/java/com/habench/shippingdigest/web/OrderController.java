package com.habench.shippingdigest.web;

import com.habench.shippingdigest.web.QuoteAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingdigestController")
public class OrderController {

    @GetMapping("/api/shipping/digest/{label}")
    public String prepare(
            @PathVariable("label") String label) {
        QuoteAdapter.collect(label);
        return "ok";
    }
}
