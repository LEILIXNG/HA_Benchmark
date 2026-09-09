package com.northwind.orderlookup.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("orderlookupController")
@RequestMapping("/api/order")
public class ReceiptController {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptController.class);
    private final LedgerTranslator ledgerTranslator;

    public ReceiptController(LedgerTranslator ledgerTranslator) {
        this.ledgerTranslator = ledgerTranslator;
    }

    @GetMapping("/lookup")
    public ResponseEntity<String> reconcile(
            @RequestHeader("X-Receipt-Correlation") String target) {
        LOG.debug("订单流程转下一环节");
        this.ledgerTranslator.route(target);
        return ResponseEntity.ok("ok");
    }
}
