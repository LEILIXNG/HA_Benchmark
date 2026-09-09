package com.northwind.inventorybatch.dao;

import org.springframework.stereotype.Repository;

/**
 * 库存的备用处理策略，当前渠道未启用。
 */
@Repository("inventorybatchBatchPlanLegacy")
public class BatchPlanLegacy implements BatchPlan {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
