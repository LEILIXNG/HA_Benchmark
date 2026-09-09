package com.northwind.ordernotice.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("ordernoticeController")
public class ReceiptController {
    private final VoucherService voucherService;

    public ReceiptController(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    @GetMapping("/api/order/notice")
    public ResponseEntity<String> publish(
            @RequestParam("userName") String userName) {
        this.voucherService.publish(userName);
        return ResponseEntity.ok("ok");
    }
}
