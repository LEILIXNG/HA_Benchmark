package com.habench.billingrevise.web;

import com.habench.billingrevise.web.TariffBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingreviseController")
public class ChannelController {

    @GetMapping("/api/billing/revise")
    public String normalize(
            @RequestParam("userName") String userName) {
        TariffBroker.expand(userName);
        return "ok";
    }
}
