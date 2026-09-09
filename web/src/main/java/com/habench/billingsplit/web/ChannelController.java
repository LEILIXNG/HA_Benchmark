package com.habench.billingsplit.web;

import com.habench.billingsplit.web.BatchBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingsplitController")
public class ChannelController {

    @GetMapping("/api/billing/split")
    public String prepare(
            @RequestHeader("X-Channel-Channel") String userName) {
        BatchBuilder.normalize(userName);
        return "ok";
    }
}
