package com.northwind.catalogtransfer.web;

import org.springframework.stereotype.Component;

/**
 * 商品的备用处理策略，当前渠道未启用。
 */
@Component("catalogtransferRefundRuleFallback")
public class RefundRuleFallback implements RefundRule {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
