package com.habench.billingtrace.web;

import com.habench.billingtrace.web.ContractTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingtraceController")
public class BundleController {

    @GetMapping("/api/billing/trace")
    public String register(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        ContractTranslator.register(target);
        return "ok";
    }
}
