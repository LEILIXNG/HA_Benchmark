package com.habench.reportverify.web;

import com.habench.reportverify.web.BatchRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportverifyController")
public class SessionController {

    @GetMapping("/api/report/verify")
    public String prepare(
            @RequestParam("resource") String resource) {
        BatchRegistry.assemble(resource);
        return "ok";
    }
}
