package com.northwind.customernotice.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("customernoticeController")
@RequestMapping("/api/customer")
public class RefundController {
    private static final Logger LOG = LoggerFactory.getLogger(RefundController.class);
    private final ReceiptRegistry receiptRegistry;

    public RefundController(ReceiptRegistry receiptRegistry) {
        this.receiptRegistry = receiptRegistry;
    }

    @GetMapping("/notice")
    public String route(
            @RequestParam("target") String target) {
        LOG.trace("进入客户处理环节");
        this.receiptRegistry.forward(target);
        return "ok";
    }
}
