package com.habench.paymentbind.web;

import com.habench.paymentbind.web.BundleComposer;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentbindController")
public class SessionController {

    @GetMapping("/api/payment/bind")
    public String resolve(
            @CookieValue("session_trace") String keyword) {
        BundleComposer.merge(keyword);
        return "ok";
    }
}
