package com.habench.paymentsettlequeue.web;

import com.habench.paymentsettlequeue.web.ReceiptComposer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentsettlequeueController")
public class SessionController {

    @GetMapping("/api/payment/settlequeue")
    public String refine(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        ReceiptComposer.publish(reference);
        return "ok";
    }
}
