package com.habench.fulfilintake.web;

import com.habench.fulfilintake.web.BundleCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilintakeController")
public class SessionController {

    @GetMapping("/api/fulfil/intake")
    public String merge(
            @RequestParam("reference") String reference) {
        BundleCoordinator.register(reference);
        return "ok";
    }
}
