package com.habench.shippingbatch.web;

import com.habench.shippingbatch.web.LedgerTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingbatchController")
public class CatalogController {

    @GetMapping("/api/shipping/batch")
    public String translate(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        LedgerTranslator.prepare(label);
        return "ok";
    }
}
