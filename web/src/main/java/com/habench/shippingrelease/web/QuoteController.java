package com.habench.shippingrelease.web;

import com.habench.shippingrelease.web.ManifestFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingreleaseController")
public class QuoteController {

    @GetMapping("/api/shipping/release")
    public String prepare(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        ManifestFacade.prepare(label);
        return "ok";
    }
}
