package com.habench.pricingcapture.web;

import com.habench.pricingcapture.web.ChannelAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingcaptureController")
public class BatchController {

    @GetMapping("/api/pricing/capture")
    public String translate(
            @RequestParam("orderNo") String orderNo) {
        ChannelAdapter.expand(orderNo);
        return "ok";
    }
}
