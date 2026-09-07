package com.habench.reportimport.web;

public final class ManifestStrategyStandard implements ManifestStrategy {
    @Override
    public void handle(String value) {
        ReceiptCoordinator.collect(value);
    }
}
