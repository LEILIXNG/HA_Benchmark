package com.habench.reportapprove.web;

import com.habench.reportapprove.web.BundleBroker;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportapproveController")
public class AccountController {

    @GetMapping("/api/report/approve")
    public String submit(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        BundleBroker.route(resource);
        return "ok";
    }
}
