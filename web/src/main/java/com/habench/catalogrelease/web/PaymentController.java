package com.habench.catalogrelease.web;

import com.habench.catalogrelease.web.OrderBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogreleaseController")
public class PaymentController {

    @GetMapping("/api/catalog/release/{resource}")
    public String submit(
            @PathVariable("resource") String resource) {
        OrderBroker.publish(resource);
        return "ok";
    }
}
