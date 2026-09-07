package com.habench.vendorsync.service;

public final class BundleRuleStandard implements BundleRule {
    @Override
    public void handle(String value) {
        AccountAdapter.assemble(value);
    }
}
