package com.habench.pricingrelease.web;

import com.habench.pricingrelease.web.SessionCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingreleaseController")
public class QuoteController {

    @GetMapping("/api/pricing/release")
    public String reconcile(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        SessionCollector.dispatch(label);
        return "ok";
    }
}
