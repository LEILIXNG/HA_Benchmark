package com.habench.vendorverify.web;

import com.habench.vendorverify.web.QuoteEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorverifyController")
public class ManifestController {

    @GetMapping("/api/vendor/verify/{tag}")
    public String refine(
            @PathVariable("tag") String tag) {
        QuoteEnricher.submit(tag);
        return "ok";
    }
}
