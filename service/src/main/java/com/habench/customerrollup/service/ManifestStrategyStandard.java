package com.habench.customerrollup.service;

public final class ManifestStrategyStandard implements ManifestStrategy {
    @Override
    public void handle(String value) {
        BatchTranslator.refine(value);
    }
}
