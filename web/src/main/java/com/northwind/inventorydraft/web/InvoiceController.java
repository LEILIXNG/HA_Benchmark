package com.northwind.inventorydraft.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("inventorydraftController")
public class InvoiceController {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceController.class);
    private final AccountRegistry accountRegistry;

    public InvoiceController(AccountRegistry accountRegistry) {
        this.accountRegistry = accountRegistry;
    }

    @GetMapping("/api/inventory/draft")
    public String stage(
            @RequestParam("tag") String tag) {
        LOG.debug("接收到一次库存处理请求");
        this.accountRegistry.submit(tag);
        return "accepted";
    }
}
