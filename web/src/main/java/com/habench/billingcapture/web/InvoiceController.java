package com.habench.billingcapture.web;

import com.habench.billingcapture.web.VoucherAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingcaptureController")
public class InvoiceController {

    @GetMapping("/api/billing/capture")
    public String route(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        VoucherAssembler.publish(reference);
        return "ok";
    }
}
