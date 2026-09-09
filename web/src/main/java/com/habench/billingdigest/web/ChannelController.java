package com.habench.billingdigest.web;

import com.habench.billingdigest.web.InvoiceBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingdigestController")
public class ChannelController {

    @GetMapping("/api/billing/digest")
    public String enrich(HttpServletRequest request) {
        String reference = request.getHeader("X-Channel-Correlation");
        InvoiceBuilder.translate(reference);
        return "ok";
    }
}
