package com.habench.billingrollup.web;

import com.habench.billingrollup.web.BundleEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingrollupController")
public class OrderController {

    @GetMapping("/api/billing/rollup")
    public String dispatch(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        BundleEnricher.translate(tag);
        return "ok";
    }
}
