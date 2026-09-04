package com.habench.shippingbind.web;

import com.habench.shippingbind.web.ReceiptAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingbindController")
public class OrderController {

    @GetMapping("/api/shipping/bind")
    public String collect(
            @RequestParam("category") String category) {
        ReceiptAssembler.route(category);
        return "ok";
    }
}
