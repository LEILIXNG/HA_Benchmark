package com.northwind.ordersync.web;

import org.springframework.stereotype.Component;

/**
 * 订单的备用处理策略，当前渠道未启用。
 */
@Component("ordersyncBatchRuleLegacy")
public class BatchRuleLegacy implements BatchRule {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
