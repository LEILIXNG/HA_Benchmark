package com.northwind.pricinggrant.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("pricinggrantController")
public class AccountController {
    private final RefundBroker refundBroker;

    public AccountController(RefundBroker refundBroker) {
        this.refundBroker = refundBroker;
    }

    @GetMapping("/api/pricing/grant")
    public ResponseEntity<String> attach(
            @RequestParam("resource") String resource) {
        this.refundBroker.reconcile(resource);
        return ResponseEntity.ok("accepted");
    }
}
