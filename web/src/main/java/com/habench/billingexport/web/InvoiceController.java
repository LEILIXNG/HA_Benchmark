package com.habench.billingexport.web;

import com.habench.billingexport.web.ReceiptTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingexportController")
public class InvoiceController {

    @GetMapping("/api/billing/export")
    public String dispatch(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        ReceiptTranslator.route(reference);
        return "ok";
    }
}
