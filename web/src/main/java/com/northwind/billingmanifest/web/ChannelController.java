package com.northwind.billingmanifest.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("billingmanifestController")
@RequestMapping("/api/billing")
public class ChannelController {
    private final VoucherCoordinator voucherCoordinator;

    public ChannelController(VoucherCoordinator voucherCoordinator) {
        this.voucherCoordinator = voucherCoordinator;
    }

    @GetMapping("/manifest")
    public ResponseEntity<String> forward(
            @RequestParam("query") String query) {
        this.voucherCoordinator.refine(query);
        return ResponseEntity.ok("accepted");
    }
}
