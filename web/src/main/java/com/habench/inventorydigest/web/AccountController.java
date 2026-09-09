package com.habench.inventorydigest.web;

import com.habench.inventorydigest.web.ShipmentRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorydigestController")
public class AccountController {

    @GetMapping("/api/inventory/digest")
    public String compose(HttpServletRequest request) {
        String token = request.getHeader("X-Account-Tenant");
        ShipmentRegistry.compose(token);
        return "ok";
    }
}
