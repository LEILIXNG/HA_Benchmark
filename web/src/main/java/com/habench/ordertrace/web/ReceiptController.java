package com.habench.ordertrace.web;

import com.habench.ordertrace.web.SessionEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordertraceController")
public class ReceiptController {

    @GetMapping("/api/order/trace")
    public String reconcile(
            @RequestParam("resource") String resource) {
        SessionEnricher.enrich(resource);
        return "ok";
    }
}
