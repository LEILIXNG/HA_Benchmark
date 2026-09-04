package com.habench.billingcapture.web;

import com.habench.billingcapture.web.VoucherComposer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingcaptureController")
public class InvoiceController {

    @GetMapping("/api/billing/capture")
    public String assemble(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        VoucherComposer.submit(filename);
        return "ok";
    }
}
