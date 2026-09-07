package com.habench.pricingmerge.web;

public final class ShipmentStrategyStandard implements ShipmentStrategy {
    @Override
    public void handle(String value) {
        RefundNormalizer.stage(value);
    }
}
