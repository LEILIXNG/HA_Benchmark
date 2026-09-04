package com.habench.catalogadjust.web;

import com.habench.catalogadjust.web.QuoteBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogadjustController")
public class QuoteController {

    @GetMapping("/api/catalog/adjust")
    public String attach(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        QuoteBuilder.normalize(resource);
        return "ok";
    }
}
