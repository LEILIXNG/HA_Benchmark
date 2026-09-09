package com.northwind.fulfilrollup.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("fulfilrollupController")
public class QuoteController {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteController.class);
    private final PaymentComposer paymentComposer;

    public QuoteController(PaymentComposer paymentComposer) {
        this.paymentComposer = paymentComposer;
    }

    @GetMapping("/api/fulfil/rollup/{keyword}")
    public ResponseEntity<String> forward(
            @PathVariable("keyword") String keyword) {
        LOG.debug("履约流程转下一环节");
        this.paymentComposer.reconcile(keyword);
        return ResponseEntity.ok("ok");
    }
}
