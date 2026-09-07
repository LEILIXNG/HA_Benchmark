package com.habench.orderquote.web;

import com.habench.orderquote.web.ManifestTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderquoteController")
public class BundleController {

    @GetMapping("/api/order/quote")
    public String submit(
            @RequestParam("label") String label) {
        ManifestTranslator.reconcile(label);
        return "ok";
    }
}
