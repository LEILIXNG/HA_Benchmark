package com.habench.billinghold.web;

import com.habench.billinghold.web.ManifestTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingholdController")
public class ReceiptController {

    @GetMapping("/api/billing/hold")
    public String register(HttpServletRequest request) {
        String keyword = request.getHeader("X-Ha-Payload");
        ManifestTranslator.attach(keyword);
        return "ok";
    }
}
