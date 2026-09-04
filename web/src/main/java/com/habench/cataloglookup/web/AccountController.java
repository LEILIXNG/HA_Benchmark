package com.habench.cataloglookup.web;

import com.habench.cataloglookup.web.SessionRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("cataloglookupController")
public class AccountController {

    @GetMapping("/api/catalog/lookup")
    public String normalize(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        SessionRegistry.normalize(target);
        return "ok";
    }
}
