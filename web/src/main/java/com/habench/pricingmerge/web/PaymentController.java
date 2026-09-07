package com.habench.pricingmerge.web;

import com.habench.pricingmerge.web.PaymentCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingmergeController")
public class PaymentController {

    @GetMapping("/api/pricing/merge")
    public String prepare(HttpServletRequest request) {
        String keyword = request.getHeader("X-Ha-Payload");
        PaymentCoordinator.assemble(keyword);
        return "ok";
    }
}
