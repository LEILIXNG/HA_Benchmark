package com.habench.reportposting.web;

import com.habench.reportposting.web.VoucherResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportpostingController")
public class ManifestController {

    @GetMapping("/api/report/posting")
    public String compose(
            @RequestParam("resource") String resource) {
        VoucherResolver.stage(resource);
        return "ok";
    }
}
