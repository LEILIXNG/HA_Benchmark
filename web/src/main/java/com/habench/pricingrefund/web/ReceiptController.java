package com.habench.pricingrefund.web;

import com.habench.pricingrefund.web.RefundCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingrefundController")
public class ReceiptController {

    @GetMapping("/api/pricing/refund")
    public String publish(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        RefundCollector.attach(reference);
        return "ok";
    }
}
