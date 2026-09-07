package com.habench.pricingapprove.web;

import com.habench.pricingapprove.web.RefundCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingapproveController")
public class CatalogController {

    @GetMapping("/api/pricing/approve")
    public String attach(
            @RequestParam("orderNo") String orderNo) {
        RefundCollector.expand(orderNo);
        return "ok";
    }
}
