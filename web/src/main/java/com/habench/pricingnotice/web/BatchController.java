package com.habench.pricingnotice.web;

import com.habench.pricingnotice.web.BatchRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingnoticeController")
public class BatchController {

    @GetMapping("/api/pricing/notice")
    public String expand(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        BatchRegistry.resolve(token);
        return "ok";
    }
}
