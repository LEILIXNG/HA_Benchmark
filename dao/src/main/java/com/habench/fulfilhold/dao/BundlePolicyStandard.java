package com.habench.fulfilhold.dao;

public final class BundlePolicyStandard implements BundlePolicy {
    @Override
    public void handle(String value) {
        ShipmentRegistry.translate(value);
    }
}
