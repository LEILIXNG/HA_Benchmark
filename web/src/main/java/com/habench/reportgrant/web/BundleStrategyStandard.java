package com.habench.reportgrant.web;

public final class BundleStrategyStandard implements BundleStrategy {
    @Override
    public void handle(String value) {
        QuoteRouter.compose(value);
    }
}
