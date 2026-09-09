package com.habench.customerquote.dao;

public final class BundlePolicyStandard implements BundlePolicy {
    @Override
    public void handle(String value) {
        ReceiptCollector.publish(value);
    }
}
