package com.habench.customerbind.web;

import com.habench.customerbind.web.InvoiceNormalizer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerbindController")
public class ReceiptController {

    @GetMapping("/api/customer/bind")
    public String merge(HttpServletRequest request) {
        String reference = request.getHeader("X-Receipt-Client");
        InvoiceNormalizer.compose(reference);
        return "ok";
    }
}
