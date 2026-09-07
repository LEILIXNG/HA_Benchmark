package com.habench.inventoryadjust.dao;

public final class BundlePolicyStandard implements BundlePolicy {
    @Override
    public void handle(String value) {
        ReceiptCollector.publish(value);
    }
}
