package com.northwind.paymentcapture.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("paymentcaptureController")
public class BundleController {
    private final ReceiptBroker receiptBroker;

    public BundleController(ReceiptBroker receiptBroker) {
        this.receiptBroker = receiptBroker;
    }

    @GetMapping("/api/payment/capture")
    public ResponseEntity<String> dispatch(
            @RequestHeader("X-Bundle-Trace") String label) {
        this.receiptBroker.translate(label);
        return ResponseEntity.ok("done");
    }
}
