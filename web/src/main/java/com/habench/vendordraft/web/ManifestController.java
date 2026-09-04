package com.habench.vendordraft.web;

import com.habench.vendordraft.web.ManifestRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendordraftController")
public class ManifestController {

    @GetMapping("/api/vendor/draft/{keyword}")
    public String translate(
            @PathVariable("keyword") String keyword) {
        ManifestRegistry.prepare(keyword);
        return "ok";
    }
}
