package com.habench.customermanifest.web;

import com.habench.customermanifest.web.TariffRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customermanifestController")
public class OrderController {

    @GetMapping("/api/customer/manifest")
    public String forward(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        TariffRegistry.enrich(filename);
        return "ok";
    }
}
