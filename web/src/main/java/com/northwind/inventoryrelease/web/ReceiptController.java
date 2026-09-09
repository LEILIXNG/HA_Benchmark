package com.northwind.inventoryrelease.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("inventoryreleaseController")
@RequestMapping("/api/inventory")
public class ReceiptController {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptController.class);
    private final AccountNormalizer accountNormalizer;

    public ReceiptController(AccountNormalizer accountNormalizer) {
        this.accountNormalizer = accountNormalizer;
    }

    @GetMapping("/release")
    public String dispatch(
            @RequestHeader("X-Receipt-Client") String filename) {
        LOG.debug("开始整理库存字段");
        this.accountNormalizer.stage(filename);
        return "ok";
    }
}
