package com.habench.pricingimport.web;

import com.habench.pricingimport.web.ReceiptNormalizer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingimportController")
public class VoucherController {

    @GetMapping("/api/pricing/import")
    public String translate(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        ReceiptNormalizer.reconcile(userName);
        return "ok";
    }
}
