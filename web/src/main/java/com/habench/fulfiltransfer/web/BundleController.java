package com.habench.fulfiltransfer.web;

import com.habench.fulfiltransfer.web.CatalogComposer;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfiltransferController")
public class BundleController {

    @GetMapping("/api/fulfil/transfer")
    public String refine(
            @CookieValue("bundle_ctx") String keyword) {
        CatalogComposer.submit(keyword);
        return "ok";
    }
}
