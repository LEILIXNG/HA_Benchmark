package com.habench.paymentadjust.web;

import com.habench.paymentadjust.web.ReceiptComposer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentadjustController")
public class RefundController {

    @GetMapping("/api/payment/adjust")
    public String compose(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        ReceiptComposer.publish(category);
        return "ok";
    }
}
