package com.habench.reportdraft.web;

import com.habench.reportdraft.web.RefundBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportdraftController")
public class QuoteController {

    @GetMapping("/api/report/draft/{label}")
    public String attach(
            @PathVariable("label") String label) {
        RefundBroker.attach(label);
        return "ok";
    }
}
