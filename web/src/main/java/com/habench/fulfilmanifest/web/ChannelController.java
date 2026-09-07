package com.habench.fulfilmanifest.web;

import com.habench.fulfilmanifest.web.ChannelNormalizer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilmanifestController")
public class ChannelController {

    @GetMapping("/api/fulfil/manifest")
    public String expand(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        ChannelNormalizer.normalize(category);
        return "ok";
    }
}
