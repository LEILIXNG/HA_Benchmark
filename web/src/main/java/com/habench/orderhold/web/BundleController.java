package com.habench.orderhold.web;

import com.habench.orderhold.web.QuoteNormalizer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderholdController")
public class BundleController {

    @GetMapping("/api/order/hold")
    public String resolve(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        QuoteNormalizer.translate(tag);
        return "ok";
    }
}
