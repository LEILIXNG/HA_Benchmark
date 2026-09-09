package com.habench.customersettle.web;

import com.habench.customersettle.web.RefundTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customersettleController")
public class QuoteController {

    @GetMapping("/api/customer/settle")
    public String register(HttpServletRequest request) {
        String resource = request.getHeader("X-Quote-Tenant");
        RefundTranslator.translate(resource);
        return "ok";
    }
}
