package com.habench.pricingnotice.web;

public final class BatchRuleStandard implements BatchRule {
    @Override
    public void handle(String value) {
        ManifestCollector.compose(value);
    }
}
