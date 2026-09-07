package com.habench.catalogmanifest.web;

import com.habench.catalogmanifest.web.BundleTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogmanifestController")
public class ChannelController {

    @GetMapping("/api/catalog/manifest/{target}")
    public String forward(
            @PathVariable("target") String target) {
        BundleTranslator.prepare(target);
        return "ok";
    }
}
