package com.habench.billingdraft.web;

import com.habench.billingdraft.web.OrderBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingdraftController")
public class ChannelController {

    @GetMapping("/api/billing/draft")
    public String compose(HttpServletRequest request) {
        String query = request.getHeader("X-Channel-Context");
        OrderBuilder.attach(query);
        return "ok";
    }
}
