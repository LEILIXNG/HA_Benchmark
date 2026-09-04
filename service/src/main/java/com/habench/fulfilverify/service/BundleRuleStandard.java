package com.habench.fulfilverify.service;

public final class BundleRuleStandard implements BundleRule {
    @Override
    public void handle(String value) {
        BatchAdapter.dispatch(value);
    }
}
