package com.habench.reportexport.web;

public final class ManifestStrategyStandard implements ManifestStrategy {
    @Override
    public void handle(String value) {
        ReceiptCollector.dispatch(value);
    }
}
