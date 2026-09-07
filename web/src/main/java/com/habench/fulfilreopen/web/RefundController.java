package com.habench.fulfilreopen.web;

import com.habench.fulfilreopen.web.ManifestCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilreopenController")
public class RefundController {

    @GetMapping("/api/fulfil/reopen")
    public String collect(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        ManifestCoordinator.merge(category);
        return "ok";
    }
}
