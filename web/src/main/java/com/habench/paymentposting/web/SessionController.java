package com.habench.paymentposting.web;

import com.habench.paymentposting.web.ChannelResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentpostingController")
public class SessionController {

    @GetMapping("/api/payment/posting")
    public String publish(
            @RequestParam("userName") String userName) {
        ChannelResolver.collect(userName);
        return "ok";
    }
}
