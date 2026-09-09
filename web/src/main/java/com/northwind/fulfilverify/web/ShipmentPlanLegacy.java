package com.northwind.fulfilverify.web;

import org.springframework.stereotype.Component;

/**
 * 履约的备用处理策略，当前渠道未启用。
 */
@Component("fulfilverifyShipmentPlanLegacy")
public class ShipmentPlanLegacy implements ShipmentPlan {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
