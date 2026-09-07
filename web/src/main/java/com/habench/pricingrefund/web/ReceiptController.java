package com.habench.pricingrefund.web;

import com.habench.pricingrefund.web.BundleEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingrefundController")
public class ReceiptController {

    @GetMapping("/api/pricing/refund")
    public String publish(
            @RequestParam("orderNo") String orderNo) {
        BundleEnricher.forward(orderNo);
        return "ok";
    }
}
