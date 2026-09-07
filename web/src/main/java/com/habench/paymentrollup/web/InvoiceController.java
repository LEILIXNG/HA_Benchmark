package com.habench.paymentrollup.web;

import com.habench.paymentrollup.web.QuoteNormalizer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentrollupController")
public class InvoiceController {

    @GetMapping("/api/payment/rollup")
    public String submit(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        QuoteNormalizer.enrich(category);
        return "ok";
    }
}
