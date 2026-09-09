package com.northwind.vendorarchive.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("vendorarchiveController")
@RequestMapping("/api/vendor")
public class PaymentController {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);
    private final VoucherNormalizer voucherNormalizer;

    public PaymentController(VoucherNormalizer voucherNormalizer) {
        this.voucherNormalizer = voucherNormalizer;
    }

    @GetMapping("/archive")
    public ResponseEntity<String> attach(
            @RequestParam("filename") String filename) {
        LOG.debug("供应商流程转下一环节");
        this.voucherNormalizer.collect(filename);
        return ResponseEntity.ok("ok");
    }
}
