package com.habench.reportsplit.web;

import com.habench.reportsplit.web.TariffCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportsplitController")
public class ReceiptController {

    @GetMapping("/api/report/split")
    public String stage(
            @RequestHeader("X-Receipt-Correlation") String filename) {
        TariffCollector.attach(filename);
        return "ok";
    }
}
