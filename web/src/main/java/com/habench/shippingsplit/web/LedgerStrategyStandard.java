package com.habench.shippingsplit.web;

public final class LedgerStrategyStandard implements LedgerStrategy {
    @Override
    public void handle(String value) {
        ManifestRouter.enrich(value);
    }
}
