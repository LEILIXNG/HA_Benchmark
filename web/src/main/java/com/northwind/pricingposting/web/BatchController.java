package com.northwind.pricingposting.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向定价场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("pricingpostingController")
@RequestMapping("/api/pricing")
public class BatchController {
    private final VoucherCoordinator voucherCoordinator;

    public BatchController(VoucherCoordinator voucherCoordinator) {
        this.voucherCoordinator = voucherCoordinator;
    }

    @GetMapping("/posting")
    public ResponseEntity<String> stage(
            @RequestHeader("X-Batch-Channel") String reference) {
        this.voucherCoordinator.refine(reference);
        return ResponseEntity.ok("ok");
    }
}
