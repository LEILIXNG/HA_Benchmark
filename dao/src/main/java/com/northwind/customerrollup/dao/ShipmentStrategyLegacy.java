package com.northwind.customerrollup.dao;

import org.springframework.stereotype.Repository;

/**
 * 客户的备用处理策略，当前渠道未启用。
 */
@Repository("customerrollupShipmentStrategyLegacy")
public class ShipmentStrategyLegacy implements ShipmentStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
