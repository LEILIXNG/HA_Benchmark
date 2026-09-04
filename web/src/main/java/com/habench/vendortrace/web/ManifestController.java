package com.habench.vendortrace.web;

import com.habench.vendortrace.web.CatalogTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendortraceController")
public class ManifestController {

    @GetMapping("/api/vendor/trace")
    public String compose(
            @RequestParam("reference") String reference) {
        CatalogTranslator.route(reference);
        return "ok";
    }
}
