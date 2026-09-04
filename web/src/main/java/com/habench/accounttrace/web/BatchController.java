package com.habench.accounttrace.web;

import com.habench.accounttrace.web.RefundCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accounttraceController")
public class BatchController {

    @GetMapping("/api/account/trace")
    public String collect(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        RefundCollector.compose(token);
        return "ok";
    }
}
