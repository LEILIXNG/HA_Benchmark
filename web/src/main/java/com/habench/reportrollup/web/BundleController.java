package com.habench.reportrollup.web;

import com.habench.reportrollup.web.BatchBroker;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportrollupController")
public class BundleController {

    @GetMapping("/api/report/rollup")
    public String resolve(HttpServletRequest request) {
        String keyword = request.getHeader("X-Ha-Payload");
        BatchBroker.collect(keyword);
        return "ok";
    }
}
