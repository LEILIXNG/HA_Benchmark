package com.habench.pricingnotice.web;

import com.habench.pricingnotice.web.CatalogCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingnoticeController")
public class BatchController {

    @GetMapping("/api/pricing/notice")
    public String prepare(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        CatalogCoordinator.forward(resource);
        return "ok";
    }
}
