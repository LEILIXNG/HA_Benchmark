package com.habench.pricingsubmit.web;

import com.habench.pricingsubmit.web.QuoteNormalizer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingsubmitController")
public class TariffController {

    @GetMapping("/api/pricing/submit")
    public String normalize(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        QuoteNormalizer.expand(category);
        return "ok";
    }
}
