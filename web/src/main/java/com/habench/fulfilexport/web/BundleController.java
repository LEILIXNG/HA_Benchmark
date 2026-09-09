package com.habench.fulfilexport.web;

import com.habench.fulfilexport.web.BundleEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilexportController")
public class BundleController {

    @GetMapping("/api/fulfil/export")
    public String route(
            @RequestHeader("X-Bundle-Context") String tag) {
        BundleEnricher.collect(tag);
        return "ok";
    }
}
