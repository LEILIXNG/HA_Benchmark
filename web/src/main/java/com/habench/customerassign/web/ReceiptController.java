package com.habench.customerassign.web;

import com.habench.customerassign.web.InvoiceNormalizer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerassignController")
public class ReceiptController {

    @GetMapping("/api/customer/assign")
    public String merge(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        InvoiceNormalizer.compose(reference);
        return "ok";
    }
}
