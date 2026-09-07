package com.habench.fulfilbind.web;

import com.habench.fulfilbind.web.SessionCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilbindController")
public class CatalogController {

    @GetMapping("/api/fulfil/bind")
    public String refine(
            @RequestParam("label") String label) {
        SessionCollector.collect(label);
        return "ok";
    }
}
