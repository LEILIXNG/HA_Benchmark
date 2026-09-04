package com.habench.shippingreopen.web;

import com.habench.shippingreopen.web.ChannelBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingreopenController")
public class QuoteController {

    @GetMapping("/api/shipping/reopen")
    public String prepare(
            @RequestParam("label") String label) {
        ChannelBuilder.stage(label);
        return "ok";
    }
}
