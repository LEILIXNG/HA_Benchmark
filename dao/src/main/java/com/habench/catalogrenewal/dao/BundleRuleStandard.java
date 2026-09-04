package com.habench.catalogrenewal.dao;

public final class BundleRuleStandard implements BundleRule {
    @Override
    public void handle(String value) {
        ShipmentRouter.attach(value);
    }
}
