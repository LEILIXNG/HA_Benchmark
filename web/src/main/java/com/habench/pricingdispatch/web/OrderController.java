package com.habench.pricingdispatch.web;

import com.habench.pricingdispatch.web.ReceiptComposer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingdispatchController")
public class OrderController {

    @GetMapping("/api/pricing/dispatch")
    public String merge(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        ReceiptComposer.refine(label);
        return "ok";
    }
}
