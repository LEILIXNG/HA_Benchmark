package com.habench.inventoryhold.web;

import com.habench.inventoryhold.web.TariffResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryholdController")
public class BundleController {

    @GetMapping("/api/inventory/hold")
    public String attach(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        TariffResolver.assemble(filename);
        return "ok";
    }
}
