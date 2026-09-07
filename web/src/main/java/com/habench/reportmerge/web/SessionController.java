package com.habench.reportmerge.web;

import com.habench.reportmerge.web.OrderCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportmergeController")
public class SessionController {

    @GetMapping("/api/report/merge")
    public String compose(HttpServletRequest request) {
        String query = request.getHeader("X-Ha-Payload");
        OrderCollector.normalize(query);
        return "ok";
    }
}
