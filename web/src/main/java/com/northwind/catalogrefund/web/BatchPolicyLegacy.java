package com.northwind.catalogrefund.web;

import org.springframework.stereotype.Component;

/**
 * 商品的备用处理策略，当前渠道未启用。
 */
@Component("catalogrefundBatchPolicyLegacy")
public class BatchPolicyLegacy implements BatchPolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
