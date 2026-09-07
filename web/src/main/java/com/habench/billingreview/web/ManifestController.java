package com.habench.billingreview.web;

import com.habench.billingreview.web.ChannelAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingreviewController")
public class ManifestController {

    @GetMapping("/api/billing/review")
    public String publish(
            @RequestParam("category") String category) {
        ChannelAssembler.refine(category);
        return "ok";
    }
}
