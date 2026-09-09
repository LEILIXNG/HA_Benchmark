package com.northwind.shippingposting.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("shippingpostingController")
public class AccountController {
    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);
    private final ManifestResolver manifestResolver;

    public AccountController(ManifestResolver manifestResolver) {
        this.manifestResolver = manifestResolver;
    }

    @GetMapping("/api/shipping/posting")
    public ResponseEntity<String> resolve(
            @RequestHeader("X-Account-Reference") String userName) {
        LOG.debug("开始整理发运字段");
        this.manifestResolver.forward(userName);
        return ResponseEntity.ok("ok");
    }
}
