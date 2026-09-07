package com.habench.shippingarchive.web;

import com.habench.shippingarchive.web.CatalogCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingarchiveController")
public class SessionController {

    @GetMapping("/api/shipping/archive")
    public String register(HttpServletRequest request) {
        String keyword = request.getHeader("X-Ha-Payload");
        CatalogCollector.submit(keyword);
        return "ok";
    }
}
