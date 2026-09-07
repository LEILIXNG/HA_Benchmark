package com.habench.inventoryreview.dao;

public final class ManifestStrategyStandard implements ManifestStrategy {
    @Override
    public void handle(String value) {
        BundleTranslator.dispatch(value);
    }
}
