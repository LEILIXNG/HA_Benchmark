package com.habench.shippingrenewal.web;

import com.habench.shippingrenewal.web.InvoiceBroker;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingrenewalController")
public class RefundController {

    @GetMapping("/api/shipping/renewal")
    public String reconcile(
            @CookieValue("refund_session") String keyword) {
        InvoiceBroker.reconcile(keyword);
        return "ok";
    }
}
