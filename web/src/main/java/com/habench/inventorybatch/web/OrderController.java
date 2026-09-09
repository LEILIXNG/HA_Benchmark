package com.habench.inventorybatch.web;

import com.habench.inventorybatch.web.OrderRegistry;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorybatchController")
public class OrderController {

    @GetMapping("/api/inventory/batch")
    public String stage(
            @CookieValue("order_trace") String filename) {
        OrderRegistry.forward(filename);
        return "ok";
    }
}
