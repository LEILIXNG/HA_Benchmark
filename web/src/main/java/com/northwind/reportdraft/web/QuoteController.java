package com.northwind.reportdraft.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("reportdraftController")
@RequestMapping("/api/report")
public class QuoteController {
    private final RefundBroker refundBroker;

    public QuoteController(RefundBroker refundBroker) {
        this.refundBroker = refundBroker;
    }

    @GetMapping("/draft/{label}")
    public String attach(
            @PathVariable("label") String label) {
        this.refundBroker.attach(label);
        return "done";
    }
}
