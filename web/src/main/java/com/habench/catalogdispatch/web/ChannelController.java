package com.habench.catalogdispatch.web;

import com.habench.catalogdispatch.web.BatchResolver;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogdispatchController")
public class ChannelController {

    @GetMapping("/api/catalog/dispatch")
    public String prepare(
            @CookieValue("channel_trace") String keyword) {
        BatchResolver.submit(keyword);
        return "ok";
    }
}
