package com.habench.pricingcapture.web;

import com.habench.pricingcapture.web.CatalogAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingcaptureController")
public class BatchController {

    @GetMapping("/api/pricing/capture")
    public String collect(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        CatalogAssembler.prepare(token);
        return "ok";
    }
}
