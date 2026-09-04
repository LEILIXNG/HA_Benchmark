package com.habench.reportsubmit.web;

import com.habench.reportsubmit.web.RefundResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportsubmitController")
public class SessionController {

    @GetMapping("/api/report/submit")
    public String prepare(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        RefundResolver.prepare(filename);
        return "ok";
    }
}
