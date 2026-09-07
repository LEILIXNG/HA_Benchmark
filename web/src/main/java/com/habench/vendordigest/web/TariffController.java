package com.habench.vendordigest.web;

import com.habench.vendordigest.web.BundleCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendordigestController")
public class TariffController {

    @GetMapping("/api/vendor/digest/{filename}")
    public String stage(
            @PathVariable("filename") String filename) {
        BundleCoordinator.register(filename);
        return "ok";
    }
}
