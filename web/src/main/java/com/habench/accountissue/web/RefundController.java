package com.habench.accountissue.web;

import com.habench.accountissue.web.ManifestBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountissueController")
public class RefundController {

    @GetMapping("/api/account/issue/{category}")
    public String route(
            @PathVariable("category") String category) {
        ManifestBuilder.translate(category);
        return "ok";
    }
}
