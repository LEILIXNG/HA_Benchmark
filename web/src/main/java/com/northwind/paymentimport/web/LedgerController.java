package com.northwind.paymentimport.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("paymentimportController")
@RequestMapping("/api/payment")
public class LedgerController {
    private final RefundGuard refundGuard;

    public LedgerController(RefundGuard refundGuard) {
        this.refundGuard = refundGuard;
    }

    @GetMapping("/import/{label}")
    public ResponseEntity<String> resolve(
            @PathVariable("label") String label) {
        this.refundGuard.resolve(label);
        return ResponseEntity.ok("ok");
    }
}
