package com.northwind.billingimport.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("billingimportController")
@RequestMapping("/api/billing")
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
    private final VoucherAssembler voucherAssembler;

    public OrderController(VoucherAssembler voucherAssembler) {
        this.voucherAssembler = voucherAssembler;
    }

    @GetMapping("/import")
    public ResponseEntity<String> merge(
            @RequestParam("filename") String filename) {
        LOG.trace("进入账务处理环节");
        this.voucherAssembler.resolve(filename);
        return ResponseEntity.ok("done");
    }
}
