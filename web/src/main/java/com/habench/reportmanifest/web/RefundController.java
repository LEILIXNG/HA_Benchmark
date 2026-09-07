package com.habench.reportmanifest.web;

import com.habench.reportmanifest.web.ChannelCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportmanifestController")
public class RefundController {

    @GetMapping("/api/report/manifest")
    public String assemble(
            @RequestParam("query") String query) {
        ChannelCollector.forward(query);
        return "ok";
    }
}
