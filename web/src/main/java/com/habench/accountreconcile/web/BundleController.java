package com.habench.accountreconcile.web;

import com.habench.accountreconcile.web.ManifestAdapter;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountreconcileController")
public class BundleController {

    @GetMapping("/api/account/reconcile")
    public String stage(
            @CookieValue("bundle_ref") String resource) {
        ManifestAdapter.publish(resource);
        return "ok";
    }
}
