package com.habench.billinggrant.web;

import com.habench.billinggrant.web.OrderResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("billinggrantController")
public class ChannelController {

    @GetMapping("/api/billing/grant/{token}")
    public String refine(
            @PathVariable("token") String token) {
        OrderResolver.expand(token);
        return "ok";
    }
}
