package com.habench.catalogsync.web;

import com.habench.catalogsync.web.ContractCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogsyncController")
public class SessionController {

    @GetMapping("/api/catalog/sync")
    public String register(HttpServletRequest request) {
        String userName = request.getHeader("X-Session-Reference");
        ContractCoordinator.normalize(userName);
        return "ok";
    }
}
