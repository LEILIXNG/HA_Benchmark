package com.habench.pricingdispatch.web;

import com.habench.pricingdispatch.web.QuoteAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingdispatchController")
public class AccountController {

    @GetMapping("/api/pricing/dispatch")
    public String merge(HttpServletRequest request) {
        String category = request.getHeader("X-Account-Trace");
        QuoteAssembler.forward(category);
        return "ok";
    }
}
