package com.habench.paymentarchive.web;

import com.habench.paymentarchive.web.BundleAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentarchiveController")
public class SessionController {

    @GetMapping("/api/payment/archive")
    public String normalize(
            @RequestHeader("X-Session-Correlation") String orderNo) {
        BundleAssembler.translate(orderNo);
        return "ok";
    }
}
