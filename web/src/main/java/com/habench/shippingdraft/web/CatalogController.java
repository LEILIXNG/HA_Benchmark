package com.habench.shippingdraft.web;

import com.habench.shippingdraft.web.RefundAdapter;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingdraftController")
public class CatalogController {

    @GetMapping("/api/shipping/draft")
    public String reconcile(
            @CookieValue("catalog_tag") String resource) {
        RefundAdapter.collect(resource);
        return "ok";
    }
}
