package com.habench.orderquote.web;

import com.habench.orderquote.web.BundleCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderquoteController")
public class BundleController {

    @GetMapping("/api/order/quote/{category}")
    public String register(
            @PathVariable("category") String category) {
        BundleCollector.collect(category);
        return "ok";
    }
}
