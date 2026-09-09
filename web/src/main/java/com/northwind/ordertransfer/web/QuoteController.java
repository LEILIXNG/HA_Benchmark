package com.northwind.ordertransfer.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("ordertransferController")
@RequestMapping("/api/order")
public class QuoteController {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteController.class);
    private final RefundBroker refundBroker;

    public QuoteController(RefundBroker refundBroker) {
        this.refundBroker = refundBroker;
    }

    @GetMapping("/transfer")
    public ResponseEntity<String> publish(
            @RequestHeader("X-Quote-Reference") String filename) {
        LOG.debug("订单流程转下一环节");
        this.refundBroker.forward(filename);
        return ResponseEntity.ok("ok");
    }
}
