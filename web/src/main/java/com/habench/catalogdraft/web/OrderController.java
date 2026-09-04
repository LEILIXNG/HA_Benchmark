package com.habench.catalogdraft.web;

import com.habench.catalogdraft.web.OrderScreen;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogdraftController")
public class OrderController {

    @GetMapping("/api/catalog/draft")
    public String stage(HttpServletRequest request) {
        String query = request.getHeader("X-Ha-Payload");
        OrderScreen.merge(query);
        return "ok";
    }
}
