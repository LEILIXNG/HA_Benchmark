package com.northwind.catalogrollup.web;

import org.springframework.stereotype.Component;

/**
 * 商品的备用处理策略，当前渠道未启用。
 */
@Component("catalogrollupContractPlanLegacy")
public class ContractPlanLegacy implements ContractPlan {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
