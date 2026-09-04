package com.habench.pricingsplit.web;

import com.habench.pricingsplit.web.InvoiceBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingsplitController")
public class BundleController {

    @GetMapping("/api/pricing/split")
    public String compose(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        InvoiceBuilder.register(reference);
        return "ok";
    }
}
