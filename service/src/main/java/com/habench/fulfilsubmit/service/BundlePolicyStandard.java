package com.habench.fulfilsubmit.service;

public final class BundlePolicyStandard implements BundlePolicy {
    @Override
    public void handle(String value) {
        ShipmentCoordinator.stage(value);
    }
}
