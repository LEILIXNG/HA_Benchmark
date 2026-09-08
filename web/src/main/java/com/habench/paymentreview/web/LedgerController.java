package com.habench.paymentreview.web;

import com.habench.paymentreview.web.BundleScreen;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentreviewController")
public class LedgerController {

    @GetMapping("/api/payment/review")
    public String compose(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        BundleScreen.merge(label);
        return "ok";
    }
}
