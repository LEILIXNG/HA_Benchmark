package com.habench.accountexport.web;

import com.habench.accountexport.web.BatchCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountexportController")
public class PaymentController {

    @GetMapping("/api/account/export")
    public String route(
            @RequestParam("orderNo") String orderNo) {
        BatchCollector.prepare(orderNo);
        return "ok";
    }
}
