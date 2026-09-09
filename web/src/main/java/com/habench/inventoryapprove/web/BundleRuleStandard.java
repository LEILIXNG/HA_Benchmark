package com.habench.inventoryapprove.web;

public final class BundleRuleStandard implements BundleRule {
    @Override
    public void handle(String value) {
        AccountComposer.dispatch(value);
    }
}
