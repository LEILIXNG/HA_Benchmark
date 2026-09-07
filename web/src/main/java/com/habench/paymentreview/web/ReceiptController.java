package com.habench.paymentreview.web;

import com.habench.paymentreview.web.BundleEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentreviewController")
public class ReceiptController {

    @GetMapping("/api/payment/review")
    public String forward(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        BundleEnricher.prepare(resource);
        return "ok";
    }
}
