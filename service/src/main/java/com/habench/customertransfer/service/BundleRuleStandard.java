package com.habench.customertransfer.service;

public final class BundleRuleStandard implements BundleRule {
    @Override
    public void handle(String value) {
        VoucherBroker.expand(value);
    }
}
