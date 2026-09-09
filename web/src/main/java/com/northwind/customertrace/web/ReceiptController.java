package com.northwind.customertrace.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向客户场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("customertraceController")
@RequestMapping("/api/customer")
public class ReceiptController {
    private final BundleNormalizer bundleNormalizer;

    public ReceiptController(BundleNormalizer bundleNormalizer) {
        this.bundleNormalizer = bundleNormalizer;
    }

    @GetMapping("/trace/{reference}")
    public ResponseEntity<String> reconcile(
            @PathVariable("reference") String reference) {
        this.bundleNormalizer.refine(reference);
        return ResponseEntity.ok("done");
    }
}
