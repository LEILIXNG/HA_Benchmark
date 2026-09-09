package com.habench.shippingreview.web;

import com.habench.shippingreview.web.BundleComposer;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingreviewController")
public class BundleController {

    @GetMapping("/api/shipping/review")
    public String refine(
            @CookieValue("bundle_ctx") String query) {
        BundleComposer.register(query);
        return "ok";
    }
}
