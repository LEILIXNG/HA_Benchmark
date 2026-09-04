package com.habench.inventoryapprove.web;

import com.habench.inventoryapprove.web.RefundCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryapproveController")
public class CatalogController {

    @GetMapping("/api/inventory/approve")
    public String register(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        RefundCollector.stage(filename);
        return "ok";
    }
}
