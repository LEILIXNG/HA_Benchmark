package com.habench.reportposting.web;

import com.habench.reportposting.web.TariffEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportpostingController")
public class ManifestController {

    @GetMapping("/api/report/posting")
    public String register(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        TariffEnricher.register(label);
        return "ok";
    }
}
