package com.habench.ordermanifest.web;

import com.habench.ordermanifest.web.ManifestAdapter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordermanifestController")
public class CatalogController {

    @GetMapping("/api/order/manifest")
    public String submit(HttpServletRequest request) {
        String query = request.getHeader("X-Ha-Payload");
        ManifestAdapter.translate(query);
        return "ok";
    }
}
