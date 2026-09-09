package com.northwind.reportclose.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向报表场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("reportcloseController")
public class RefundController {
    private static final Logger LOG = LoggerFactory.getLogger(RefundController.class);
    private final VoucherRegistry voucherRegistry;

    public RefundController(VoucherRegistry voucherRegistry) {
        this.voucherRegistry = voucherRegistry;
    }

    @GetMapping("/api/report/close/{reference}")
    public ResponseEntity<String> stage(
            @PathVariable("reference") String reference) {
        LOG.debug("报表流程转下一环节");
        this.voucherRegistry.dispatch(reference);
        return ResponseEntity.ok("ok");
    }
}
