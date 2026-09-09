package com.habench.pricingexport.web;

public final class LedgerStrategyStandard implements LedgerStrategy {
    @Override
    public void handle(String value) {
        BundleFacade.translate(value);
    }
}
