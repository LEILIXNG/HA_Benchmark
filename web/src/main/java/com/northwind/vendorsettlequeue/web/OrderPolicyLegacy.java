package com.northwind.vendorsettlequeue.web;

import org.springframework.stereotype.Component;

/**
 * 供应商的备用处理策略，当前渠道未启用。
 */
@Component("vendorsettlequeueOrderPolicyLegacy")
public class OrderPolicyLegacy implements OrderPolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
