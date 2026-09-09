package com.northwind.catalogsplit.dao;

/**
 * 商品的备用处理策略，当前渠道未启用。
 */
public final class ShipmentRuleExtended implements ShipmentRule {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
