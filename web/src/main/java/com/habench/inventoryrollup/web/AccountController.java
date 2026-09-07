package com.habench.inventoryrollup.web;

import com.habench.inventoryrollup.web.BundleCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryrollupController")
public class AccountController {

    @GetMapping("/api/inventory/rollup")
    public String publish(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        BundleCoordinator.assemble(token);
        return "ok";
    }
}
