package com.habench.pricingrenewal.web;

import com.habench.pricingrenewal.web.ChannelCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingrenewalController")
public class SessionController {

    @GetMapping("/api/pricing/renewal")
    public String collect(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        ChannelCoordinator.enrich(userName);
        return "ok";
    }
}
