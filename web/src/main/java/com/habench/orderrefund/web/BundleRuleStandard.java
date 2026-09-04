package com.habench.orderrefund.web;

public final class BundleRuleStandard implements BundleRule {
    @Override
    public void handle(String value) {
        ManifestRouter.dispatch(value);
    }
}
