package com.habench.billingreview.dao;

public final class BundleRuleStandard implements BundleRule {
    @Override
    public void handle(String value) {
        CatalogEnricher.resolve(value);
    }
}
