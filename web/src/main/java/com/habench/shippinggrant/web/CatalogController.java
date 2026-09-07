package com.habench.shippinggrant.web;

import com.habench.shippinggrant.web.ManifestAdapter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippinggrantController")
public class CatalogController {

    @GetMapping("/api/shipping/grant")
    public String submit(HttpServletRequest request) {
        String query = request.getHeader("X-Ha-Payload");
        ManifestAdapter.translate(query);
        return "ok";
    }
}
