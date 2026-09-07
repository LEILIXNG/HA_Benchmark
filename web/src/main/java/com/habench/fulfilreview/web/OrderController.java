package com.habench.fulfilreview.web;

import com.habench.fulfilreview.web.ChannelBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilreviewController")
public class OrderController {

    @GetMapping("/api/fulfil/review")
    public String collect(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        ChannelBuilder.register(token);
        return "ok";
    }
}
