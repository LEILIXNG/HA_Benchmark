package com.habench.reportnotice.web;

import com.habench.reportnotice.web.ManifestRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportnoticeController")
public class TariffController {

    @GetMapping("/api/report/notice")
    public String translate(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        ManifestRegistry.dispatch(reference);
        return "ok";
    }
}
