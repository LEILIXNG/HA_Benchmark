package com.habench.customerarchive.web;

import com.habench.customerarchive.web.BundleEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerarchiveController")
public class SessionController {

    @GetMapping("/api/customer/archive")
    public String compose(
            @RequestHeader("X-Session-Reference") String filename) {
        BundleEnricher.stage(filename);
        return "ok";
    }
}
