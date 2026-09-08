package com.habench.reporttrace.web;

import com.habench.reporttrace.web.BatchResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reporttraceController")
public class SessionController {

    @GetMapping("/api/report/trace")
    public String enrich(
            @RequestParam("keyword") String keyword) {
        BatchResolver.publish(keyword);
        return "ok";
    }
}
