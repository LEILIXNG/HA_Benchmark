package com.habench.accountreview.web;

import com.habench.accountreview.web.BundleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountreviewController")
public class CatalogController {

    @GetMapping("/api/account/review")
    public String dispatch(
            @RequestHeader("X-Catalog-Client") String token) {
        BundleService.translate(token);
        return "ok";
    }
}
