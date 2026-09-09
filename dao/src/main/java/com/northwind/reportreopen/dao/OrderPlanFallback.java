package com.northwind.reportreopen.dao;

import org.springframework.stereotype.Repository;

/**
 * 报表的备用处理策略，当前渠道未启用。
 */
@Repository("reportreopenOrderPlanFallback")
public class OrderPlanFallback implements OrderPlan {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
