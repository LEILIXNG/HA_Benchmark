package com.habench.accountrelease.web;

import com.habench.accountrelease.web.QuoteEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountreleaseController")
public class ManifestController {

    @GetMapping("/api/account/release")
    public String merge(HttpServletRequest request) {
        String keyword = request.getHeader("X-Manifest-Reference");
        QuoteEnricher.resolve(keyword);
        return "ok";
    }
}
