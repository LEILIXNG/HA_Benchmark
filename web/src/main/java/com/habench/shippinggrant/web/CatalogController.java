package com.habench.shippinggrant.web;

import com.habench.shippinggrant.web.ShipmentBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippinggrantController")
public class CatalogController {

    @GetMapping("/api/shipping/grant")
    public String attach(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        ShipmentBuilder.stage(token);
        return "ok";
    }
}
