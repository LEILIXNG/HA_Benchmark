package com.habench.vendorrenewal.service;

public final class BundlePolicyStandard implements BundlePolicy {
    @Override
    public void handle(String value) {
        RefundCollector.merge(value);
    }
}
