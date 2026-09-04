package com.habench.pricingquote.service;

public final class ManifestRuleStandard implements ManifestRule {
    @Override
    public void handle(String value) {
        RefundBuilder.reconcile(value);
    }
}
