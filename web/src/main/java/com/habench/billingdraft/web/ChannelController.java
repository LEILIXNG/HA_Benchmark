package com.habench.billingdraft.web;

import com.habench.billingdraft.web.ManifestCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingdraftController")
public class ChannelController {

    @GetMapping("/api/billing/draft")
    public String submit(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        ManifestCollector.route(filename);
        return "ok";
    }
}
