package com.habench.catalogarchive.web;

import com.habench.catalogarchive.web.TariffRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogarchiveController")
public class ShipmentController {

    @GetMapping("/api/catalog/archive")
    public String enrich(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        TariffRegistry.collect(filename);
        return "ok";
    }
}
