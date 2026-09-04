package com.habench.pricingrelease.web;

import com.habench.pricingrelease.web.BatchCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingreleaseController")
public class QuoteController {

    @GetMapping("/api/pricing/release")
    public String route(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        BatchCollector.publish(userName);
        return "ok";
    }
}
