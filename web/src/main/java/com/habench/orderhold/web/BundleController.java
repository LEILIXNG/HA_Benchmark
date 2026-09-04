package com.habench.orderhold.web;

import com.habench.orderhold.web.PaymentNormalizer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderholdController")
public class BundleController {

    @GetMapping("/api/order/hold")
    public String submit(HttpServletRequest request) {
        String keyword = request.getHeader("X-Ha-Payload");
        PaymentNormalizer.attach(keyword);
        return "ok";
    }
}
