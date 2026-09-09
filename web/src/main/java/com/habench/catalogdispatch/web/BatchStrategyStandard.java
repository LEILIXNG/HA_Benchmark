package com.habench.catalogdispatch.web;

public final class BatchStrategyStandard implements BatchStrategy {
    @Override
    public void handle(String value) {
        BundleTranslator.merge(value);
    }
}
