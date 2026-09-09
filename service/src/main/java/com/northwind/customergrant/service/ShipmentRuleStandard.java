package com.northwind.customergrant.service;

/**
 * 客户的默认处理策略。
 */
public final class ShipmentRuleStandard implements ShipmentRule {

    @Override
    public void handle(String value) {
        SessionRegistry.forward(value);
    }
}
