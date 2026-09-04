package com.habench.reportmerge.web;

import com.habench.reportmerge.web.AccountRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportmergeController")
public class SessionController {

    @GetMapping("/api/report/merge/{query}")
    public String resolve(
            @PathVariable("query") String query) {
        AccountRegistry.refine(query);
        return "ok";
    }
}
