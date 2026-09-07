package com.habench.billingrollup.web;

public final class BundleRuleStandard implements BundleRule {
    @Override
    public void handle(String value) {
        QuoteTranslator.reconcile(value);
    }
}
