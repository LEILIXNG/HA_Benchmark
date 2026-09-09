package com.habench.catalogmanifest.web;

import com.habench.catalogmanifest.web.ChannelAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogmanifestController")
public class ChannelController {

    @GetMapping("/api/catalog/manifest")
    public String attach(HttpServletRequest request) {
        String reference = request.getHeader("X-Channel-Client");
        ChannelAssembler.forward(reference);
        return "ok";
    }
}
