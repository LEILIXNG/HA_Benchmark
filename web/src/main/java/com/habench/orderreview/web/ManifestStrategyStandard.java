package com.habench.orderreview.web;

public final class ManifestStrategyStandard implements ManifestStrategy {
    @Override
    public void handle(String value) {
        InvoiceCollector.route(value);
    }
}
