package com.habench.reportdispatch.web;

import com.habench.reportdispatch.web.RefundBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportdispatchController")
public class QuoteController {

    @GetMapping("/api/report/dispatch/{label}")
    public String attach(
            @PathVariable("label") String label) {
        RefundBroker.attach(label);
        return "ok";
    }
}
