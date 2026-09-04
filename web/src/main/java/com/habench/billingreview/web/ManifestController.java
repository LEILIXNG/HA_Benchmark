package com.habench.billingreview.web;

import com.habench.billingreview.web.CatalogNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingreviewController")
public class ManifestController {

    @GetMapping("/api/billing/review")
    public String assemble(
            @RequestParam("orderNo") String orderNo) {
        CatalogNormalizer.expand(orderNo);
        return "ok";
    }
}
