package com.habench.billingtransfer.web;

import com.habench.billingtransfer.web.ChannelNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingtransferController")
public class BatchController {

    @GetMapping("/api/billing/transfer")
    public String resolve(
            @RequestParam("userName") String userName) {
        ChannelNormalizer.route(userName);
        return "ok";
    }
}
