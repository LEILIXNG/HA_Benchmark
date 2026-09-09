package com.northwind.pricingledger.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("pricingledgerController")
@RequestMapping("/api/pricing")
public class BundleController {
    private final BundleBuilder bundleBuilder;

    public BundleController(BundleBuilder bundleBuilder) {
        this.bundleBuilder = bundleBuilder;
    }

    @GetMapping("/ledger/{token}")
    public ResponseEntity<String> compose(
            @PathVariable("token") String token) {
        this.bundleBuilder.translate(token);
        return ResponseEntity.ok("ok");
    }
}
