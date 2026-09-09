package com.habench.vendornotice.service;

public final class BundleRuleStandard implements BundleRule {
    @Override
    public void handle(String value) {
        AccountBroker.resolve(value);
    }
}
