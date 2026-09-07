package com.habench.fulfiladjust.web;

import com.habench.fulfiladjust.web.BatchEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfiladjustController")
public class OrderController {

    @GetMapping("/api/fulfil/adjust")
    public String expand(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        BatchEnricher.expand(reference);
        return "ok";
    }
}
