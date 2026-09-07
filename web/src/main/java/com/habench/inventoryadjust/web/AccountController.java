package com.habench.inventoryadjust.web;

import com.habench.inventoryadjust.web.ShipmentResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryadjustController")
public class AccountController {

    @GetMapping("/api/inventory/adjust")
    public String merge(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        ShipmentResolver.stage(resource);
        return "ok";
    }
}
