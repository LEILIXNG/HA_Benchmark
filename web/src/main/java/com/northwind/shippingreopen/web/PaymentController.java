package com.northwind.shippingreopen.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("shippingreopenController")
@RequestMapping("/api/shipping")
public class PaymentController {
    private final BatchCollector batchCollector;

    public PaymentController(BatchCollector batchCollector) {
        this.batchCollector = batchCollector;
    }

    @GetMapping("/reopen")
    public String refine(
            @RequestHeader("X-Payment-Tenant") String query) {
        this.batchCollector.reconcile(query);
        return "done";
    }
}
