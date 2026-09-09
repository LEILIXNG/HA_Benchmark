package com.habench.fulfilbatch.web;

import com.habench.fulfilbatch.web.SessionCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilbatchController")
public class TariffController {

    @GetMapping("/api/fulfil/batch")
    public String enrich(
            @RequestParam("resource") String resource) {
        SessionCoordinator.stage(resource);
        return "ok";
    }
}
