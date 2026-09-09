package com.northwind.catalogsplit.dao;

/**
 * 商品的默认处理策略。
 */
public final class ShipmentRuleStandard implements ShipmentRule {

    @Override
    public void handle(String value) {
        SessionRouter.normalize(value);
    }
}
