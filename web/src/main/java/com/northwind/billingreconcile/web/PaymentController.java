package com.northwind.billingreconcile.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向账务场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("billingreconcileController")
@RequestMapping("/api/billing")
public class PaymentController {
    private final TariffService tariffService;

    public PaymentController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @GetMapping("/reconcile")
    public ResponseEntity<String> stage(
            @RequestParam("label") String label) {
        this.tariffService.merge(label);
        return ResponseEntity.ok("ok");
    }
}
