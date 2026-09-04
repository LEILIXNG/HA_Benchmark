package com.habench.pricingreview.web;

import com.habench.pricingreview.web.RefundTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingreviewController")
public class ChannelController {

    @GetMapping("/api/pricing/review")
    public String reconcile(
            @RequestParam("token") String token) {
        RefundTranslator.stage(token);
        return "ok";
    }
}
