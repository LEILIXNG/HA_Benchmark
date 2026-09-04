package com.habench.reportgrant.web;

import com.habench.reportgrant.web.RefundRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportgrantController")
public class OrderController {

    @GetMapping("/api/report/grant")
    public String merge(
            @RequestParam("userName") String userName) {
        RefundRegistry.assemble(userName);
        return "ok";
    }
}
