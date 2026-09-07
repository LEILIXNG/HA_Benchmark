package com.habench.billingnotice.web;

import com.habench.billingnotice.web.RefundTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingnoticeController")
public class QuoteController {

    @GetMapping("/api/billing/notice")
    public String register(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        RefundTranslator.translate(resource);
        return "ok";
    }
}
