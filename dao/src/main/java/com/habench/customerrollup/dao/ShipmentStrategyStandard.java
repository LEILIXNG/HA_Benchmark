package com.habench.customerrollup.dao;

public final class ShipmentStrategyStandard implements ShipmentStrategy {
    @Override
    public void handle(String value) {
        BundleTranslator.enrich(value);
    }
}
