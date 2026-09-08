package com.habench.ordertrace.web;

import com.habench.ordertrace.web.RefundCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordertraceController")
public class QuoteController {

    @GetMapping("/api/order/trace/{category}")
    public String publish(
            @PathVariable("category") String category) {
        RefundCoordinator.enrich(category);
        return "ok";
    }
}
