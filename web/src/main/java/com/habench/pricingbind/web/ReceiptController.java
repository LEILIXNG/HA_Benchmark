package com.habench.pricingbind.web;

import com.habench.pricingbind.web.InvoiceCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingbindController")
public class ReceiptController {

    @GetMapping("/api/pricing/bind")
    public String reconcile(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        InvoiceCoordinator.forward(reference);
        return "ok";
    }
}
