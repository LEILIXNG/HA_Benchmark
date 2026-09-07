package com.habench.catalogmerge.web;

import com.habench.catalogmerge.web.LedgerResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogmergeController")
public class ChannelController {

    @GetMapping("/api/catalog/merge")
    public String register(
            @RequestParam("resource") String resource) {
        LedgerResolver.assemble(resource);
        return "ok";
    }
}
