package com.habench.reportapprove.web;

public final class RefundStrategyStandard implements RefundStrategy {
    @Override
    public void handle(String value) {
        CatalogEnricher.translate(value);
    }
}
