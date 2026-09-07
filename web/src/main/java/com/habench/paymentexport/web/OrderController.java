package com.habench.paymentexport.web;

import com.habench.paymentexport.web.CatalogTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentexportController")
public class OrderController {

    @GetMapping("/api/payment/export")
    public String translate(HttpServletRequest request) {
        String keyword = request.getHeader("X-Ha-Payload");
        CatalogTranslator.register(keyword);
        return "ok";
    }
}
