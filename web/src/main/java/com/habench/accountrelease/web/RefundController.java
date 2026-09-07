package com.habench.accountrelease.web;

import com.habench.accountrelease.web.ManifestEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountreleaseController")
public class RefundController {

    @GetMapping("/api/account/release")
    public String assemble(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        ManifestEnricher.forward(filename);
        return "ok";
    }
}
