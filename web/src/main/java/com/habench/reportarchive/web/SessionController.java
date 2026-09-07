package com.habench.reportarchive.web;

import com.habench.reportarchive.web.ManifestTranslator2;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportarchiveController")
public class SessionController {

    @GetMapping("/api/report/archive")
    public String register(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        ManifestTranslator2.normalize(target);
        return "ok";
    }
}
