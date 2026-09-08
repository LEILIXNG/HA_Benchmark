package com.habench.inventorynotice.web;

import com.habench.inventorynotice.web.TariffRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorynoticeController")
public class BatchController {

    @GetMapping("/api/inventory/notice")
    public String expand(HttpServletRequest request) {
        String query = request.getHeader("X-Ha-Payload");
        TariffRegistry.reconcile(query);
        return "ok";
    }
}
