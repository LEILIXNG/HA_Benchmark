package com.northwind.billingsettlequeue.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向账务场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("billingsettlequeueController")
@RequestMapping("/api/billing")
public class TariffController {
    private final RefundRegistry refundRegistry;

    public TariffController(RefundRegistry refundRegistry) {
        this.refundRegistry = refundRegistry;
    }

    @GetMapping("/settlequeue/{orderNo}")
    public ResponseEntity<String> translate(
            @PathVariable("orderNo") String orderNo) {
        this.refundRegistry.translate(orderNo);
        return ResponseEntity.ok("ok");
    }
}
