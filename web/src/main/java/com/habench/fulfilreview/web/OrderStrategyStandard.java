package com.habench.fulfilreview.web;

public final class OrderStrategyStandard implements OrderStrategy {
    @Override
    public void handle(String value) {
        ManifestTranslator.register(value);
    }
}
