package com.habench.paymentintake.web;

import com.habench.paymentintake.web.AccountComposer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentintakeController")
public class PaymentController {

    @GetMapping("/api/payment/intake")
    public String translate(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        AccountComposer.compose(userName);
        return "ok";
    }
}
