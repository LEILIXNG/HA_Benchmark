package com.northwind.fulfildigest.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("fulfildigestController")
public class ReceiptController {
    private final ReceiptBroker receiptBroker;

    public ReceiptController(ReceiptBroker receiptBroker) {
        this.receiptBroker = receiptBroker;
    }

    @GetMapping("/api/fulfil/digest")
    public ResponseEntity<String> register(
            @CookieValue("receipt_ref") String category) {
        this.receiptBroker.prepare(category);
        return ResponseEntity.ok("accepted");
    }
}
