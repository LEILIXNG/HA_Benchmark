package com.habench.accountreconcile.service;

public final class BundleStrategyStandard implements BundleStrategy {
    @Override
    public void handle(String value) {
        CatalogTranslator.assemble(value);
    }
}
