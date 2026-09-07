package com.habench.paymenttrace.web;

import com.habench.paymenttrace.web.ChannelBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymenttraceController")
public class SessionController {

    @GetMapping("/api/payment/trace")
    public String publish(
            @RequestParam("orderNo") String orderNo) {
        ChannelBuilder.normalize(orderNo);
        return "ok";
    }
}
