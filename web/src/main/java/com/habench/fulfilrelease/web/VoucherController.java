package com.habench.fulfilrelease.web;

import com.habench.fulfilrelease.web.BundleComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilreleaseController")
public class VoucherController {

    @GetMapping("/api/fulfil/release")
    public String forward(
            @RequestParam("label") String label) {
        BundleComposer.publish(label);
        return "ok";
    }
}
