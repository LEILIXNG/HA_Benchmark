package com.habench.inventoryimport.web;

public final class BundleRuleStandard implements BundleRule {
    @Override
    public void handle(String value) {
        QuoteTranslator.reconcile(value);
    }
}
