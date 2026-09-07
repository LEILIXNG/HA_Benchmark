package com.habench.fulfilintake.web;

import com.habench.fulfilintake.web.ManifestNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilintakeController")
public class SessionController {

    @GetMapping("/api/fulfil/intake")
    public String attach(
            @RequestParam("keyword") String keyword) {
        ManifestNormalizer.refine(keyword);
        return "ok";
    }
}
