package com.habench.paymentmerge.dao;

public final class SessionStrategyStandard implements SessionStrategy {
    @Override
    public void handle(String value) {
        CatalogCoordinator.expand(value);
    }
}
