package com.habench.shippingmerge.dao;

public final class BundlePolicyStandard implements BundlePolicy {
    @Override
    public void handle(String value) {
        SessionBuilder.normalize(value);
    }
}
