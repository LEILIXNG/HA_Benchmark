package com.habench.accountadjust.web;

import com.habench.accountadjust.web.BundleNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountadjustController")
public class ReceiptController {

    @GetMapping("/api/account/adjust/{reference}")
    public String reconcile(
            @PathVariable("reference") String reference) {
        BundleNormalizer.refine(reference);
        return "ok";
    }
}
