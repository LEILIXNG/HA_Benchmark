package com.habench.paymentcapture.web;

import com.habench.paymentcapture.web.RefundResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentcaptureController")
public class BundleController {

    @GetMapping("/api/payment/capture")
    public String dispatch(
            @RequestHeader("X-Bundle-Trace") String label) {
        RefundResolver.prepare(label);
        return "ok";
    }
}
