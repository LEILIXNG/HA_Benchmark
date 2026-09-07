package com.habench.billingnotice.web;

import com.habench.billingnotice.web.ContractCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingnoticeController")
public class QuoteController {

    @GetMapping("/api/billing/notice")
    public String register(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        ContractCoordinator.expand(reference);
        return "ok";
    }
}
