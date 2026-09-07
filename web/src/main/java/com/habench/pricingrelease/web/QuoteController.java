package com.habench.pricingrelease.web;

import com.habench.pricingrelease.web.SessionCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingreleaseController")
public class QuoteController {

    @GetMapping("/api/pricing/release")
    public String assemble(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        SessionCollector.prepare(token);
        return "ok";
    }
}
