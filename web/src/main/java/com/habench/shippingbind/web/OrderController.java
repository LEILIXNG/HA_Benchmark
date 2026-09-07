package com.habench.shippingbind.web;

import com.habench.shippingbind.web.CatalogCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingbindController")
public class OrderController {

    @GetMapping("/api/shipping/bind")
    public String publish(
            @RequestParam("category") String category) {
        CatalogCollector.dispatch(category);
        return "ok";
    }
}
