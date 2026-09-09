package com.habench.fulfilassign.web;

import com.habench.fulfilassign.web.BatchRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilassignController")
public class SessionController {

    @GetMapping("/api/fulfil/assign")
    public String prepare(
            @RequestParam("resource") String resource) {
        BatchRegistry.assemble(resource);
        return "ok";
    }
}
