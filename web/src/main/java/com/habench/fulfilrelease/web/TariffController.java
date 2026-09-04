package com.habench.fulfilrelease.web;

import com.habench.fulfilrelease.web.ManifestService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilreleaseController")
public class TariffController {

    @GetMapping("/api/fulfil/release")
    public String collect(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        ManifestService.expand(orderNo);
        return "ok";
    }
}
