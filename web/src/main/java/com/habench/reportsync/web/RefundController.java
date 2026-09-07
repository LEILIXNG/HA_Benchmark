package com.habench.reportsync.web;

import com.habench.reportsync.web.InvoiceBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportsyncController")
public class RefundController {

    @GetMapping("/api/report/sync/{category}")
    public String refine(
            @PathVariable("category") String category) {
        InvoiceBroker.publish(category);
        return "ok";
    }
}
