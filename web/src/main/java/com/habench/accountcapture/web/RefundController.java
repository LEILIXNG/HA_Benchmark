package com.habench.accountcapture.web;

import com.habench.accountcapture.web.ChannelBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountcaptureController")
public class RefundController {

    @GetMapping("/api/account/capture")
    public String attach(
            @RequestParam("category") String category) {
        ChannelBuilder.dispatch(category);
        return "ok";
    }
}
