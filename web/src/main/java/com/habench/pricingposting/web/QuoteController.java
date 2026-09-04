package com.habench.pricingposting.web;

import com.habench.pricingposting.web.InvoiceRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingpostingController")
public class QuoteController {

    @GetMapping("/api/pricing/posting")
    public String forward(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        InvoiceRegistry.assemble(label);
        return "ok";
    }
}
