package com.habench.catalogverify.web;

import com.habench.catalogverify.web.ChannelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogverifyController")
public class ChannelController {

    @GetMapping("/api/catalog/verify/{category}")
    public String refine(
            @PathVariable("category") String category) {
        ChannelService.merge(category);
        return "ok";
    }
}
