package com.northwind.catalogdispatch.dao;

import org.springframework.stereotype.Repository;

/**
 * 商品的备用处理策略，当前渠道未启用。
 */
@Repository("catalogdispatchContractPlanLegacy")
public class ContractPlanLegacy implements ContractPlan {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
