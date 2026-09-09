package com.northwind.vendoradjust.web;

import org.springframework.stereotype.Component;

/**
 * 供应商的备用处理策略，当前渠道未启用。
 */
@Component("vendoradjustQuotePlanFallback")
public class QuotePlanFallback implements QuotePlan {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
