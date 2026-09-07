package com.habench.paymenthold.dao;

public final class BundlePolicyExtended implements BundlePolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
