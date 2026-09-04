package com.habench.billingassign.web;

import com.habench.billingassign.web.SessionResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingassignController")
public class TariffController {

    @GetMapping("/api/billing/assign")
    public String refine(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        SessionResolver.publish(resource);
        return "ok";
    }
}
