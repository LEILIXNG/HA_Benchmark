package com.northwind.customerrollup.dao;

import org.springframework.stereotype.Repository;

/**
 * 客户的默认处理策略。
 */
@Repository("customerrollupShipmentStrategyStandard")
public class ShipmentStrategyStandard implements ShipmentStrategy {
    private final BundleTranslator bundleTranslator;

    public ShipmentStrategyStandard(BundleTranslator bundleTranslator) {
        this.bundleTranslator = bundleTranslator;
    }

    @Override
    public void handle(String value) {
        this.bundleTranslator.enrich(value);
    }
}
