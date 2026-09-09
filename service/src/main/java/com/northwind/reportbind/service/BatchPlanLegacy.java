package com.northwind.reportbind.service;

import org.springframework.stereotype.Service;

/**
 * 报表的备用处理策略，当前渠道未启用。
 */
@Service("reportbindBatchPlanLegacy")
public class BatchPlanLegacy implements BatchPlan {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
