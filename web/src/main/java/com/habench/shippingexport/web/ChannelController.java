package com.habench.shippingexport.web;

import com.habench.shippingexport.web.BundleTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingexportController")
public class ChannelController {

    @GetMapping("/api/shipping/export")
    public String submit(
            @RequestParam("token") String token) {
        BundleTranslator.expand(token);
        return "ok";
    }
}
