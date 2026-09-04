package com.habench.inventorymanifest.web;

import com.habench.inventorymanifest.web.RefundResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorymanifestController")
public class CatalogController {

    @GetMapping("/api/inventory/manifest")
    public String publish(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        RefundResolver.register(tag);
        return "ok";
    }
}
