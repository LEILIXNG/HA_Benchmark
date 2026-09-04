package com.habench.fulfilapprove.web;

import com.habench.fulfilapprove.web.ShipmentEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilapproveController")
public class LedgerController {

    @GetMapping("/api/fulfil/approve")
    public String route(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        ShipmentEnricher.translate(token);
        return "ok";
    }
}
