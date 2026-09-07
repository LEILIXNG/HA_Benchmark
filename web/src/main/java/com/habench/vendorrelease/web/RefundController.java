package com.habench.vendorrelease.web;

import com.habench.vendorrelease.web.OrderTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorreleaseController")
public class RefundController {

    @GetMapping("/api/vendor/release")
    public String assemble(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        OrderTranslator.reconcile(tag);
        return "ok";
    }
}
