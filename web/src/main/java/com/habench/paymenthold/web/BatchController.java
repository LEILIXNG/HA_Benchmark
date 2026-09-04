package com.habench.paymenthold.web;

import com.habench.paymenthold.web.SessionComposer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentholdController")
public class BatchController {

    @GetMapping("/api/payment/hold")
    public String collect(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        SessionComposer.submit(orderNo);
        return "ok";
    }
}
