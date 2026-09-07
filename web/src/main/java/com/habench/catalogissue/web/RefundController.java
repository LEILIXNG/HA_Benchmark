package com.habench.catalogissue.web;

import com.habench.catalogissue.web.ManifestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogissueController")
public class RefundController {

    @GetMapping("/api/catalog/issue")
    public String expand(
            @RequestParam("token") String token) {
        ManifestService.normalize(token);
        return "ok";
    }
}
