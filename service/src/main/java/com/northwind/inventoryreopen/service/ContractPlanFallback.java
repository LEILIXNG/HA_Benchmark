package com.northwind.inventoryreopen.service;

import org.springframework.stereotype.Service;

/**
 * 库存的备用处理策略，当前渠道未启用。
 */
@Service("inventoryreopenContractPlanFallback")
public class ContractPlanFallback implements ContractPlan {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
