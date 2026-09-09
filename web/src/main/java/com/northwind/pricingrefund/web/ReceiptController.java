package com.northwind.pricingrefund.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("pricingrefundController")
@RequestMapping("/api/pricing")
public class ReceiptController {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptController.class);
    private final BundleEnricher bundleEnricher;

    public ReceiptController(BundleEnricher bundleEnricher) {
        this.bundleEnricher = bundleEnricher;
    }

    @GetMapping("/refund")
    public ResponseEntity<String> publish(
            @RequestParam("orderNo") String orderNo) {
        LOG.trace("进入定价处理环节");
        this.bundleEnricher.forward(orderNo);
        return ResponseEntity.ok("accepted");
    }
}
