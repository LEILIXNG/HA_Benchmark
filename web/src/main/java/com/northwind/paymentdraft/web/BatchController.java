package com.northwind.paymentdraft.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("paymentdraftController")
@RequestMapping("/api/payment")
public class BatchController {
    private static final Logger LOG = LoggerFactory.getLogger(BatchController.class);
    private final ReceiptComposer receiptComposer;

    public BatchController(ReceiptComposer receiptComposer) {
        this.receiptComposer = receiptComposer;
    }

    @GetMapping("/draft/{keyword}")
    public ResponseEntity<String> stage(
            @PathVariable("keyword") String keyword) {
        LOG.debug("开始整理支付字段");
        this.receiptComposer.merge(keyword);
        return ResponseEntity.ok("accepted");
    }
}
