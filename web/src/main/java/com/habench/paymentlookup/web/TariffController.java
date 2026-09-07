package com.habench.paymentlookup.web;

import com.habench.paymentlookup.web.ChannelBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentlookupController")
public class TariffController {

    @GetMapping("/api/payment/lookup")
    public String attach(
            @RequestParam("orderNo") String orderNo) {
        ChannelBuilder.publish(orderNo);
        return "ok";
    }
}
