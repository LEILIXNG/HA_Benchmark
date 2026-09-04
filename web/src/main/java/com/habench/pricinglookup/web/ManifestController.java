package com.habench.pricinglookup.web;

import com.habench.pricinglookup.web.BundleAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricinglookupController")
public class ManifestController {

    @GetMapping("/api/pricing/lookup/{keyword}")
    public String submit(
            @PathVariable("keyword") String keyword) {
        BundleAdapter.resolve(keyword);
        return "ok";
    }
}
