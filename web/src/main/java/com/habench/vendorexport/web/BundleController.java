package com.habench.vendorexport.web;

import com.habench.vendorexport.web.BatchBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorexportController")
public class BundleController {

    @GetMapping("/api/vendor/export/{filename}")
    public String publish(
            @PathVariable("filename") String filename) {
        BatchBuilder.merge(filename);
        return "ok";
    }
}
