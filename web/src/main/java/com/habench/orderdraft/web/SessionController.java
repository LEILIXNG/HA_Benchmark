package com.habench.orderdraft.web;

import com.habench.orderdraft.web.BatchEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderdraftController")
public class SessionController {

    @GetMapping("/api/order/draft")
    public String stage(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        BatchEnricher.refine(label);
        return "ok";
    }
}
