package com.habench.reportissue.web;

public final class CatalogStrategyStandard implements CatalogStrategy {
    @Override
    public void handle(String value) {
        BundleBroker.prepare(value);
    }
}
