package com.habench.vendorverify.web;

import com.habench.vendorverify.web.QuoteRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorverifyController")
public class ManifestController {

    @GetMapping("/api/vendor/verify")
    public String refine(
            @RequestParam("label") String label) {
        QuoteRouter.normalize(label);
        return "ok";
    }
}
