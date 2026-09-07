package com.habench.reportgrant.web;

import com.habench.reportgrant.web.ChannelCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportgrantController")
public class OrderController {

    @GetMapping("/api/report/grant")
    public String stage(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        ChannelCollector.compose(label);
        return "ok";
    }
}
