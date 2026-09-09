package com.habench.customertrace.web;

import com.habench.customertrace.web.BundleNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customertraceController")
public class ReceiptController {

    @GetMapping("/api/customer/trace/{reference}")
    public String reconcile(
            @PathVariable("reference") String reference) {
        BundleNormalizer.refine(reference);
        return "ok";
    }
}
