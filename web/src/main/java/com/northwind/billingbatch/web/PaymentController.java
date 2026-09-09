package com.northwind.billingbatch.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("billingbatchController")
@RequestMapping("/api/billing")
public class PaymentController {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);
    private final ReceiptService receiptService;

    public PaymentController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping("/batch/{category}")
    public String compose(
            @PathVariable("category") String category) {
        LOG.debug("开始整理账务字段");
        this.receiptService.submit(category);
        return "done";
    }
}
