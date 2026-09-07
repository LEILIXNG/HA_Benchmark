package com.habench.accounttrace.web;

import com.habench.accounttrace.web.ManifestBroker;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accounttraceController")
public class BatchController {

    @GetMapping("/api/account/trace")
    public String refine(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        ManifestBroker.prepare(tag);
        return "ok";
    }
}
